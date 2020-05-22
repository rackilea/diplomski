public class TestBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements TestVisitor<T> {

    @Override
    public T visitFunctionInvStmt(TestParser.FunctionInvStmtContext ctx) { return visitChildren(ctx); }

    @Override
    public T visitParamInvList(TestParser.ParamInvListContext ctx) { return visitChildren(ctx); }

    @Override
    public T visitExpression(TestParser.ExpressionContext ctx) { return visitChildren(ctx); }

    // ...
}