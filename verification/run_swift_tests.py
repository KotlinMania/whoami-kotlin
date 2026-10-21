"""Run the four real Whoami Swift cases and preserve their complete compiler log."""
import os
from pathlib import Path
import re
import shlex
import subprocess
import sys

root = Path(__file__).resolve().parent.parent
command = ['swift', 'test', '--scratch-path', str(root / 'build/swift-harness-km2'), '--jobs', '2', '-v', '-Xswiftc', '-warnings-as-errors',
           '-Xswiftc', '-target', '-Xswiftc', 'arm64-apple-macosx15.0']
developer = subprocess.check_output(['xcode-select', '-p'], text=True).strip()
if developer.endswith('CommandLineTools'):
    frameworks = developer + '/Library/Developer/Frameworks'
    command += ['-Xswiftc', '-F', '-Xswiftc', frameworks, '-Xlinker', '-F', '-Xlinker', frameworks,
                '-Xlinker', '-rpath', '-Xlinker', frameworks,
                '-Xlinker', '-rpath', '-Xlinker', developer + '/Library/Developer/usr/lib']
result = subprocess.run(command, cwd=root / 'swift-test-harness', stdout=subprocess.PIPE,
                        stderr=subprocess.STDOUT, text=True, env={**os.environ, 'MACOSX_DEPLOYMENT_TARGET': '15.0'})
log = root / 'build/reports/swift/consumer.log'
log.parent.mkdir(parents=True, exist_ok=True)
log.write_text(result.stdout)
print(result.stdout, end='')
subprocess.run(['python3', str(root / 'verification/prepare_swift_tooling.py'), '--output',
                str(root / 'build/swift-tooling-km2'), '--verify-only'], check=True)
if result.returncode:
    sys.exit(result.returncode)
frontends = []
for line in result.stdout.splitlines():
    if 'swift-frontend' not in line or ' -frontend ' not in line:
        continue
    args = shlex.split(line)
    if '-module-name' not in args:
        continue
    module = args[args.index('-module-name') + 1]
    mode = args[args.index('-swift-version') + 1] if '-swift-version' in args else None
    if '-warnings-as-errors' not in args:
        raise ValueError('Frontend lacks warnings as errors: ' + module)
    if module == 'SwiftTestHarnessTests' and mode != '6':
        raise ValueError('Authored consumer is not explicitly Swift 6')
    if module not in ['SwiftTestHarnessTests', 'SwiftTestHarnessPackageTests', 'SwiftTestHarnessPackageDiscoveredTests'] and mode != '5':
        raise ValueError('Generated dependency is not explicitly Swift 5: ' + module)
    frontends.append(module)
if 'SwiftTestHarnessTests' not in frontends or 'Whoami' not in frontends:
    raise ValueError('Missing actual dependency/consumer frontend evidence')
names = ['architectureDisplayNames', 'platformDisplayNames', 'languageCountryAndDisplay', 'countryAndWidthDisplay']
for name in names:
    if len(re.findall(r'Test ' + re.escape(name) + r'\(\) passed', result.stdout)) != 1:
        raise ValueError('Expected exactly one passed execution: ' + name)
if len(re.findall(r'Test run with 4 tests? in .* passed', result.stdout)) != 1:
    raise ValueError('Expected exactly four Swift behavior cases')
