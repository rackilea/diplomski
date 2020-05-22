private final Object lock = new Object();
private boolean initialized = false;

void init() {
    synchronized (lock) {
        if (!initialized) {
            someMethod();
            initialized = true;
        }
    }
}