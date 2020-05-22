// Abstract Foo
public abstract class AbstractFoo {
    protected Long id;
    protected String color;
    //...
}

// Abstract Decorator(wraps foo)
public abstract class FooDecorator extends AbstractFoo {
    // ...
}