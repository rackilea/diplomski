class Locker implements AutoCloseable {
    private final Lock lock;
    Locker(Lock lock) { this.lock = Objects.requireNonNull(lock);
                        this.lock.lock(); }
    @Override public void close() { lock.unlock(); }
}

Lock lock = ...;
try (Locker locker = new Locker(lock)) {
    // If both modifySharedState() and unlock()
    // throw an exception, the unlock() exception
    // is added to the modifySharedState()
    // exception's suppressed list.
    modifySharedState();
}