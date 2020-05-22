public enum Operations {

    POWER("^", Math::pow),
    MULTIPLICATION("*", (a, b) -> a * b);

    private String op;
    private Operation calc;

    public Operations(String op, Operation calc) {
        this.op = op;
        this.calc = calc;
    }
}