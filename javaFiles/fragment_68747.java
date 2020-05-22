public class EvalVisitor extends ExpressionsBaseVisitor<Integer> {

    @Override
    public Integer visitOpExpr(@NotNull ExpressionsParser.OpExprContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        String op = ctx.op.getText();
        switch (op.charAt(0)) {
            case '*': return left * right;
            case '/': return left / right;
            case '+': return left + right;
            case '-': return left - right;
            default: throw new IllegalArgumentException("Unknown operator " + op);
        }
    }

    @Override
    public Integer visitStart(@NotNull ExpressionsParser.StartContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Integer visitAtomExpr(@NotNull ExpressionsParser.AtomExprContext ctx) {
        return Integer.valueOf(ctx.getText());
    }

    @Override
    public Integer visitParenExpr(@NotNull ExpressionsParser.ParenExprContext ctx) {
        return this.visit(ctx.expr());
    }

    public static void main(String[] args) {
        String expression = "2 * (3 + 4)";
        ExpressionsLexer lexer = new ExpressionsLexer(new ANTLRInputStream(expression));
        ExpressionsParser parser = new ExpressionsParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        Integer answer = new EvalVisitor().visit(tree);
        System.out.printf("%s = %s\n", expression, answer);
    }
}