public enum ArithmeticOperator implements BiFunction<Double, Double, Double>  {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BiFunction<Double, Double, Double> operation;

    ArithmeticOperator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Double apply (Double a, Double b) {
        return operation.apply(a, b);
    }

    public String toString() {
        return symbol;
    }
}