public enum Operator {
    ADD(1), SUBTRACT(1), MULTIPLY(2), DIVIDE(2);
    final int precedence;
    Operator(int p) { precedence = p; }

    private static Map<String, Operator> ops = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};

    public static Operator fromString(String token){
        return ops.get(token);
    }

    public static boolean isOperator(String token) {
        return ops.containsKey(token);
    }

    public boolean hasHigherPrecedenceThan(String token) {
        return isOperator(token) && this.precedence >= fromString(token).precedence;
    }
}