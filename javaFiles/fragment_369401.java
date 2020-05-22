class Foo {
    private Bar bar;
    public Foo(Bar bar) {
        this.bar = bar;
    }
}

class Bar {
    private Foo foo;
    setFoo(Foo foo) {
        this.foo = foo;
    }
}


Bar bar = new Bar();
Foo foo = new Foo(bar);
bar.setFoo(foo);