public final void foo() {
    synchronized (this) {
        fooImpl();
    }
};
protected void fooImpl() {
    // ...
}