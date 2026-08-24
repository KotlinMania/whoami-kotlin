# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 6/17 (35.3%)
- **Function parity:** 9/131 matched (target 23) — 6.9%
- **Class/type parity:** 7/18 matched (target 68) — 38.9%
- **Combined symbol parity:** 16/149 matched (target 91) — 10.7%
- **Average inline-code cosine:** 0.58 (function body across 6 matched files)
- **Average documentation cosine:** 0.70 (doc text across 6 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 4 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. result

- **Target:** `whoami.Result`
- **Similarity:** 1.00
- **Dependents:** 2
- **Priority Score:** 2000100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 1/1 matched
- **Missing types:** _none_

### 2. arch

- **Target:** `whoami.Arch`
- **Similarity:** 0.46
- **Dependents:** 0
- **Priority Score:** 405.4
- **Functions:** 2/2 matched (target 7)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 26)
- **Missing types:** _none_

### 3. desktop_env

- **Target:** `whoami.DesktopEnv`
- **Similarity:** 0.57
- **Dependents:** 0
- **Priority Score:** 404.3
- **Functions:** 3/3 matched (target 6)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 20)
- **Missing types:** _none_

### 4. language

- **Target:** `whoami.Language`
- **Similarity:** 0.64
- **Dependents:** 0
- **Priority Score:** 403.6
- **Functions:** 2/2 matched (target 5)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 5)
- **Missing types:** _none_

### 5. platform

- **Target:** `whoami.Platform`
- **Similarity:** 0.43
- **Dependents:** 0
- **Priority Score:** 205.7
- **Functions:** 1/1 matched (target 4)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 16)
- **Missing types:** _none_

### 6. conversions

- **Target:** `whoami.Conversions`
- **Similarity:** 0.39
- **Dependents:** 0
- **Priority Score:** 106.1
- **Functions:** 1/1 matched
- **Missing functions:** _none_
- **Types:** 0/0 matched
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Missing

| Source | Expected target | Deps | Source path | Expected path |
|--------|-----------------|------|-------------|---------------|
| `lib` | `Lib` | 0 | `lib.rs` | `Lib.kt` |

