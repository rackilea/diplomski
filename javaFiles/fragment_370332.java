public class Foo {
    Bar b = new Bar();
    Clazz c = new Clazz(b); 
}

public class Clazz {
    private final Bar bar;
    public Clazz (Bar bar) {
        this.bar = bar;
    }
    public void example () {
        doSomething(bar);
    }
}