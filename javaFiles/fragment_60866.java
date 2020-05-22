class AstVisitorBuilder extends TestBaseVisitor<Ast> {

    @Override
    public Ast visitFunctionInvStmt(TestParser.FunctionInvStmtContext ctx) {

        final String functionName = ctx.NAME().getText();
        final List<Ast> arguments = new ArrayList<>();

        if (ctx.paramInvList().expression() != null) {
            for (TestParser.ExpressionContext expression : ctx.paramInvList().expression()) {
                arguments.add(this.visitExpression(expression));
            }
        }

        return new FunctionInvocationExpr(functionName, arguments);
    }

    @Override
    public Ast visitExpression(TestParser.ExpressionContext ctx) {
        return null; // TODO return your expression AST node here
    }

    // ...
}