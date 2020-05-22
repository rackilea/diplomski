// All the safe optimizations.
options.dependencyOptions.setDependencySorting(true);
options.closurePass = true;
options.foldConstants = true;
options.coalesceVariableNames = true;
options.deadAssignmentElimination = true;
options.extractPrototypeMemberDeclarations = true;
options.collapseVariableDeclarations = true;
options.convertToDottedProperties = true;
options.rewriteFunctionExpressions = true;
options.labelRenaming = true;
options.removeDeadCode = true;
options.optimizeArgumentsArray = true;
options.collapseObjectLiterals = true;
options.protectHiddenSideEffects = true;

// All the advance optimizations.
options.removeClosureAsserts = true;
options.aliasKeywords = true;
options.reserveRawExports = true;
options.setRenamingPolicy(
    VariableRenamingPolicy.ALL, PropertyRenamingPolicy.ALL_UNQUOTED);
options.shadowVariables = true;
options.removeUnusedPrototypeProperties = true;
options.removeUnusedPrototypePropertiesInExterns = true;
options.collapseAnonymousFunctions = true;
options.collapseProperties = true;
options.checkGlobalThisLevel = CheckLevel.WARNING;
options.rewriteFunctionExpressions = true;
options.smartNameRemoval = true;
options.inlineConstantVars = true;
options.setInlineFunctions(Reach.ALL);
options.inlineGetters = true;
options.setInlineVariables(Reach.ALL);
options.flowSensitiveInlineVariables = true;
options.computeFunctionSideEffects = true;

// Remove unused vars also removes unused functions.
options.setRemoveUnusedVariables(Reach.ALL);

// Move code around based on the defined modules.
options.crossModuleCodeMotion = true;
options.crossModuleMethodMotion = true;

// Call optimizations
options.devirtualizePrototypeMethods = true;
options.optimizeParameters = true;
options.optimizeReturns = true;
options.optimizeCalls = true;