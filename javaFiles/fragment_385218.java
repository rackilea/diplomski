class A {
    protected final boolean b;

    protected A() {
    this(false);
    }
    protected A(boolean b) {
       this. b = b;
    }
}

class B extends A {
    public B() {
        super(true);
    }
}