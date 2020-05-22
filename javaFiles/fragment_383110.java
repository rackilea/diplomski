enum MathOperators implements MathOperator {
    ADD {
        @Override
        public double operate(double a, double b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        public double operate(double a, double b) {
            return a - b;
        }
    }
}