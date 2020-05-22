public class Foo {
    Bar b = new Bar();
    Clazz c = new Clazz(this); // be warned: `this` is not fully constructed yet.
    public Bar getB () { return b; }
}

public class Clazz {
    private final Foo owner;
    public Clazz (Foo owner) {
        this.owner = owner;
    }
    public void example () {
        doSomething(owner.getB());
    }
}