public void setDebugOptionsForCompilationLevel(CompilerOptions options) {
    options.anonymousFunctionNaming = AnonymousFunctionNamingPolicy.UNMAPPED;
    options.generatePseudoNames = true;
    options.removeClosureAsserts = false;
    // Don't shadow variables as it is too confusing.
    options.shadowVariables = false;
}