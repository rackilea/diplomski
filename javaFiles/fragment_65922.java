class FooClass implements FooInterface {

    private int value;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void printValue() {
        System.out.println(String.valueOf(value));
    }

    @Override  // can't use FooClass for parameter here
    public int difference(FooInterface fi) {
        return value - fi.getValue();
    }

}