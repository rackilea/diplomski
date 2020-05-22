private final Object lock = new Object();

public void run() {
    synchronized (lock) {
        doSomething();
    }
}