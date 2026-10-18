# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 5/17 (29.4%)
- **Function parity:** 11/133 matched (target 23) — 8.3%
- **Class/type parity:** 6/18 matched (target 67) — 33.3%
- **Combined symbol parity:** 17/151 matched (target 90) — 11.3%
- **Average inline-code cosine:** 0.12 (function body across 5 matched files)
- **Average documentation cosine:** 0.76 (doc text across 5 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 5 files with <0.60 function similarity
- **Needs Review:** 0 files with 0.60-0.84 function similarity
- **Excellent:** 0 files with >=0.85 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. language

- **Target:** `whoami.Language`
- **Similarity:** 0.09
- **Dependents:** 0
- **Priority Score:** 509.1
- **Functions:** 3/3 matched (target 5)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 5)
- **Missing types:** _none_

### 2. arch

- **Target:** `whoami.Arch`
- **Similarity:** 0.15
- **Dependents:** 0
- **Priority Score:** 508.5
- **Functions:** 3/3 matched (target 7)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 26)
- **Missing types:** _none_

### 3. desktop_env

- **Target:** `whoami.DesktopEnv`
- **Similarity:** 0.19
- **Dependents:** 0
- **Priority Score:** 408.1
- **Functions:** 3/3 matched (target 6)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 20)
- **Missing types:** _none_

### 4. platform

- **Target:** `whoami.Platform`
- **Similarity:** 0.18
- **Dependents:** 0
- **Priority Score:** 208.2
- **Functions:** 1/1 matched (target 4)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 16)
- **Missing types:** _none_

### 5. conversions

- **Target:** `whoami.Conversions`
- **Similarity:** 0.01
- **Dependents:** 0
- **Priority Score:** 109.9
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

