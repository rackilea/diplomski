public static void generate(int length) {
    if (length <= 0)
        throw new IllegalArgumentException();
    StringBuilder expr = new StringBuilder();
    for (int number = 0; number <= 12; number++) {
        expr.append(number);
        generate(expr, number, length - 1);
        expr.setLength(0);
    }
}
private static void generate(StringBuilder expr, int exprTotal, int remainingLength) {
    if (remainingLength == 0) {
        System.out.println(expr);
        return;
    }
    final int exprLength = expr.length();
    for (int number = 0; number <= 12; number++) {
        if (number != exprTotal) {
            for (Operator oper : Operator.values()) {
                int total = oper.method.applyAsInt(exprTotal, number);
                if (total >= 0 && total <= 12) {
                    expr.append(oper.symbol).append(number)
                        .append("(=").append(total).append(")");
                    generate(expr, total, remainingLength - 1);
                    expr.setLength(exprLength);
                }
            }
        }
    }
}
private enum Operator {
    PLUS    ('+', Math::addExact),
    MINUS   ('-', Math::subtractExact),
    MULTIPLY('*', Math::multiplyExact),
    DIVIDE  ('/', Operator::divide);

    final char symbol;
    final IntBinaryOperator method;
    private Operator(char symbol, IntBinaryOperator method) {
        this.symbol = symbol;
        this.method = method;
    }
    private static int divide(int left, int right) {
        if (right == 0 || left % right != 0)
            return -1/*No exact integer value*/;
        return left / right;
    }
}