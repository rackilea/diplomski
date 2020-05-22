class MathOperators {
    public static MathOperator ADD = new MathOperator() {
        @Override
        public double operate(double a, double b) {
            return a + b;
        }
    };
    public static MathOperator SUBTRACT = new MathOperator() {
        @Override
        public double operate(double a, double b) {
            return a - b;
        }
    };
}