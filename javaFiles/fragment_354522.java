class Foo {
    static class Companion { }
    static final Foo.Companion Companion = new Foo.Companion();

    final Baz bar;
    Foo(Baz bar) { this.bar = bar; }
}