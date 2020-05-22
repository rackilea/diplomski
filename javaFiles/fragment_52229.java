public class Parent implements Serializable {
    private int i;
    // ...
}

public class Child extends Parent {
    private final Thread t = new Thread();   // a non-serializable object
    // ...
}