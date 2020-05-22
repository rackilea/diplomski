@Test
public void testArray() throws Exception {
    String testExpr = "xyz[3].aaa[1].bbb[2]";

    Document document;
    ASTParser parser;
    parser = ASTParser.newParser(AST.JLS8);
    parser.setKind(ASTParser.K_EXPRESSION);
    parser.setResolveBindings(true);
    String exprString = testExpr.replace("\"", "").replace("+", "").replace('[', '(').replace(']', ')');

    document = new Document(exprString);
    parser.setSource(document.get().toCharArray());
    Object o = parser.createAST(null);

    if (o instanceof CompilationUnit) {
        CompilationUnit cu = (CompilationUnit) o;
        IProblem[] problems = cu.getProblems();
        System.err.println(problems);
    }
    Expression expr = (Expression) o;
    final ASTRewrite rewriter = ASTRewrite.create(expr.getAST());
    final AST ast = expr.getAST();
    final TextEditGroup textEdits = new TextEditGroup("test");

    expr.accept(new ASTVisitor() {
        @Override
        public boolean visit(MethodInvocation node) {
            String getter = getGetter(node.getName().getIdentifier().toString());

            rewriter.replace(node.getName(), 
                    ast.newSimpleName(getter),
                    textEdits);
            return super.visit(node);
        }


    });

    TextEdit edits = rewriter.rewriteAST(document, null);
    edits.apply(document);

    assertEquals("getXyz(3).getAaa(1).getBbb(2)", 
            document.get());
}