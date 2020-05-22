Parser parser = Parser.create();
CompilationUnitTree tree = parser.parse(file, new InputStreamReader(stream), null);

if (tree != null) {
    tree.accept(new BasicTreeVisitor<Void, Void>() {
        public Void visitFunctionCall(FunctionCallTree functionCallTree, Void v) {
             System.out.println("Found a functionCall: " + functionCallTree.getFunctionSelect().getKind​());
             return null;
         }
     }, null);
}