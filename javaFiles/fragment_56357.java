public class Foo {
    ...
    public Foo withBar(...) {
        Foo f = new Foo(this.param);
        f.setBar(...);
        return f;
    }

    public Foo withBaz(...) {
        Foo f = new Foo(this.param);
        f.setBaz(...);
        return f;
    }
}
...
Foo y = ...;
Foo x = y.withBar(...);