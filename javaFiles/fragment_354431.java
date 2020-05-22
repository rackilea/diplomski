interface FooBar extends Foo, Bar {
    public static FooBar combine(Foo f, Bar b) {
        return new FooBar() {
            foo() { f.foo(); }
            bar() { b.bar(); }
        }
    }
}