class FloatAcc {
    private Float total;
    public FloatAcc(Float initial) {
        total = initial;
    }
    public void accumulate(Float item) {
        total += item;
    }
    public Float get() {
        return total;
    }
}