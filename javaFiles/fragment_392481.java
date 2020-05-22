stream.reduce(
    new IntBinaryOperator() {
        public int applyAsInt(int a, int b) {
            return b > a ? b : a;
        }
    }
);