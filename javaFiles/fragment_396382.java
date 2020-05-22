class ServiceBaseClass {
    protected Z z;

    protected YourBaseClass() {
    }

    public final void process(X x) {
        z = ...;
        ...
        f(x, y);
        ...
        g(x);
    }

    protected void f(X x, Y y) {
    }

    protected void g(X x) {
        ... z ...
    }
}