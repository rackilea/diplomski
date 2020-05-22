// I hate synchronizing on "this"
private final Object lock = new Object();

public final void foo() {
    synchronized(lock) {
        fooImpl();
    }
}

protected abstract void fooImpl();