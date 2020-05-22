private static CompilationUnit createCompilationUnit(String sourceFile,
        String unitName) {
    String source = readWithStringBuilder(sourceFile);
    ASTParser parser = ASTParser.newParser(AST.JLS3); 
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(source.toCharArray()); // set source
    String[] classpathEntries = ...;
    String[] sourcepathEntries = ...;
    parser.setEnvironment(classpathEntries, sourcepathEntries, null, true);
    parser.setUnitName(unitName);
    parser.setResolveBindings(true);
    // optional
    // parser.setBindingsRecovery(true);
    return (CompilationUnit) parser.createAST(null /* IProgressMonitor */); // parse
}