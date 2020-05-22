abstract class AbstractFoo {
    public String value() { return "Foo"; }

    public AbstractFoo doStuff() {
        // Logic logic logic
        return hook();
    }

    protected abstract AbstractFoo hook();
}

class Foo extends AbstractFoo {
    protected AbstractFoo hook() { return new Foo(); }
}

class Bar extends AbstractFoo {
    public String value() { return "Bar"; }

    protected AbstractFoo hook() { return new Bar(); }
}

new Bar().doStuff().value(); // Returns 'Bar'!