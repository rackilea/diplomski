public Foo(Bar bar) {
    this(bar.expensiveFunction(), true);
}

public Foo(Baz baz) {
    this(baz, false);
}

private Foo(Baz baz, boolean close) {
    super();
    try {
       // initialize
    } finally {
        if (close) {
            baz.close();
        }
    }
}