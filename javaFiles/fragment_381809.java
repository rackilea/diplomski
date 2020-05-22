class Foobar {
    private final Object lock = new Object();

    public void do_something() {
        synchronized(lock) {
            ...
        }
    }
}