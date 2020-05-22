class MyVisitor extends MyGrammarBaseVisitor<String> {
    @Override
    public String visitMultiplicative(MyGrammarParser.MultiplicativeContext ctx) {
        if (ctx.opMult().getText().equals("/")) return "\\frac{" + visit(ctx.expr(0)) + "}{" + visit(ctx.expr(1)) + "}";
        else return visit(ctx.expr(0)) + "\\cdot " + visit(ctx.expr(1));
    }
    // visit methods for other rules...
}