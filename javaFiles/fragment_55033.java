// locks should be final objects so the object instance we are synchronizing on,
// never changes
private final Object lock = new Object();
...
// ensure that the thread has a mutex lock on some key code
synchronized (lock) {
    ...
    // i need to wait for other threads to finish with some resource
    // this releases the lock and waits on the associated monitor
    lock.wait();
    ...
    // i need to signal another thread that some state has changed and they can
    // awake and continue to run
    lock.notify();
}