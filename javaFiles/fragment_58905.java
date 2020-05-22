public class A {
    private final B b;
    A(B b) {
        this.b = b;
    }
}

public class B {
    private /*not-final*/ A a;
    public void setA(A a) {
        this.a = a;
    }
}