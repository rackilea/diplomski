public abstract class Parent {
    protected boolean foo;
    protected Parent() {
        this(false); // initialize foo to default value
    }
    protected Parent(boolean fooValue) {
        this.foo = fooValue;
    }
}

public class Child1 extends Parent {
    public Child1() {
        super(true);
    }
}

public class Child2 extends Parent {
    // no explicit super(boolean) call in c'tor gives foo the default value
}