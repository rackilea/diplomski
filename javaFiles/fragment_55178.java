public class CloseableLock implements Closeable {
    private final Lock lock;

    private CloseableLock(Lock l) {
        lock = l;
    }

    public void close() {
        lock.unlock();
    }

    public static CloseableLock lock(Lock l) {
        l.lock();
        return new CloseableLock(l);
    }
}

try(CloseableLock l = CloseableLock.lock(lock)) { // acquire the lock
    // do something
} // release the lock