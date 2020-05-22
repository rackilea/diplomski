class A {
    private final B b;
    public A(B b) { this.b = b; }

    public void methodToTest() {
        b.wantToVerifyThisIsCalled();
    }
}

class B {
    private final C c;
    private final D d;
    public B(C c, D d) { this.c = c; this.d = d; }

    public void wantToVerifyThisIsCalled() { ... }
}