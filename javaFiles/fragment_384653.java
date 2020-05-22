public TestConstructor(FooComponent1 f1, FooComponent2 f2, Baz baz) {
    this(createFoo(f1, f2), baz);
}

private TestConstructor(Foo foo, Baz bar) {
    this(foo, createBar(baz));
}

private TestConstructor(Foo foo, Bar bar) {
    // do whatever
}