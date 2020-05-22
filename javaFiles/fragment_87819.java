public static String showExpr(final Expr expr) {
    if(expr.isLit()) {
        return Integer.toString(expr.asLit().n);
    } else if(expr.isAdd()) {
        return "(" + expr.asAdd().a + "+" + expr.asAdd().b + ")";
    }
}