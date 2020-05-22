class Foo<T> {

    public Foo() {
        new T();
    }
}

class Bar {
    private Bar() {}
}

class FooBar {
    public FooBar() {
       Foo<Bar> foo = new Foo<>();
    }
}