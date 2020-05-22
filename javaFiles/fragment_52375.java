private final Object lock = new Object();
private volatile boolean initialized = false;

void init() {
    if (!initialized) {
        synchronized (lock) {
            if (!initialized) {
                someMethod();
                initialized = true;
            }
        }
    }
}