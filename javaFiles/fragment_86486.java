public abstract class Parent {
    protected final String birthmark;
    protected Parent(String s) {
        birthmark = s;
    }
}

public class Child extends Parent {
    public Child(String s) {
        super(s);
        ...
    }
}