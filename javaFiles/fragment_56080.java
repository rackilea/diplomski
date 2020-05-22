public class A {
    private final B = new B();
    public void f1() { this.b.f3(this); }
    public void f2() { /* do something */ }
}

public class B {
    public void f3(A a) { a.f2(); }
}