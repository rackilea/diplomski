class Foo {
    int x = 0;
}
class Bar {
    changeFoo(final Foo foo) {
        foo.x = foo.x + 1; //allowed even if `foo` is marked as final
        foo = new Foo(); //compiler error...
    }
}