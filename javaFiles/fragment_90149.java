class Foo {
    private Foo parent;

    Foo() {
        this.parent = null;
    }

    Foo(Foo f) {
        this.parent = f;
    }

    public Foo spawn() {
        return new Foo(this);
    }
}