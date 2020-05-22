class ImmutableInteger {
    private final int value;

    public ImmutableInteger(int value) {this.value = value;}

    public int value() {return value;}

    public ImmutableInteger add(int a) {
        // instead of changing this state, we will create new instance with result
        return new ImmutableInteger(value + a);
    }
}