public class Foo {
    public Foo() {
        // If this is called by someone saying "new Foo()", I must be a Foo.
    }
}

public class Bar extends Foo {
    public Bar() {
        // If this is called by someone saying "new Bar()", I must be a Bar.
    }
}

public class FooFactory {
    public static Foo buildAFoo() {
        // This method can return either a Foo, a Bar,
        // or anything else that extends Foo.
    }
}