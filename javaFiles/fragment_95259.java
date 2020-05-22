public interface Foo {
    @BypassCheck boolean getEnabled();
    @BypassCheck void setEnabled(boolean enable);

    void bar();
    void baz();
    void bat();

    // Needs Java 8 to have this convenience method here.
    static Foo newFoo() {
        FooFactory fooFactory = new FooFactory();
        return fooFactory.makeFoo();
    }
}