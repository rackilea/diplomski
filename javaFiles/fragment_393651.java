class CreationParams {
    private final int foo;
    private final int bar;

    CreationParams(final int foo, final int bar) {
        this.foo = foo;
        this.bar = bar;
    }

    // make sure to implement hashCode & equals so this class can be efficiently used in a Map
}