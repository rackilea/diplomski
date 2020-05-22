class MutableInteger {
    private int value;

    public MutableInteger(int value) {this.value = value;}

    public int value() {return value;}

    public MutableInteger add(int a) {
        value += a; // mutating internal state
        return this;
    }
}