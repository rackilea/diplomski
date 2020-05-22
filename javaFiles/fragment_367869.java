class A {
    private B b;

    public A() {
        this.b = new B(this);
    }
}

class B {
    private A a;

    public B(A a) {
        this.a = a;
    }
}