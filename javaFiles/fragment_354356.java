public static double exp(double x, int n) {
    return DoubleStream.iterate(1, new DoubleUnaryOperator() {

        private int i = 1;

        @Override
        public double applyAsDouble(double operand) {
            return operand * x / i++;
        }

    }).limit(n).sum();
}