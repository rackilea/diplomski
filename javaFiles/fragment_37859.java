class FooKey {
    final int x;

    public FooKey(int x) {
        this.x = x;
    }

    // TODO Override equals and hashCode to only compare FooKeys on x field
}

class Foo {
    final FooKey id;
    int y;
    int z;

    public Foo(FooKey id) {
        this.id = id;
    }
}