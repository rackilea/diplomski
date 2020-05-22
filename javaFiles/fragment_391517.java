public SomeClass() {
    this(new Foo());
}

public SomeClass(Foo foo) {
    this(foo, new Bar(foo));
}