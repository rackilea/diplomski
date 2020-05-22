private static CompilationUnit createCompilationUnit(String sourceFile,
        IJavaProject javaProject) {
    String source = readWithStringBuilder(sourceFile);
    ASTParser parser = ASTParser.newParser(AST.JLS3); 
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(source.toCharArray()); // set source
    parser.setProject(javaProject);
    parser.setResolveBindings(true); // we need bindings later on
    return (CompilationUnit) parser.createAST(null /* IProgressMonitor */); // parse
}