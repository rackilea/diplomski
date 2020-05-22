enum Operation {
    ADD {
        @Override
        public void performOn(int firstValue, int secondValue) {
            return firstValue + secondValue;
        }
    },
    SUBTRACT {
        //...
    };

    public abstract int performOn(int firstValue, int secondValue);
}