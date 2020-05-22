class C extends A {
    private B b; // instance member

    public C(B b) {
        this.b = b;
    }

    public void x() {
        // do stuff
        b.x();
    }
}