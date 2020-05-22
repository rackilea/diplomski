static class LockProxy<L extends Lock> implements Lock {

    // The actual lock.
    private volatile Lock lock;

    public LockProxy(L lock) {
        // Trap the lock we are proxying.
        this.lock = lock;
    }

    @Override
    public void lock() {
        // Proxy it.
        lock.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // Proxy it.
        lock.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        // Proxy it.
        return lock.tryLock();
    }

    @Override
    public boolean tryLock(long l, TimeUnit tu) throws InterruptedException {
        // Proxy it.
        return lock.tryLock(l, tu);
    }

    @Override
    public void unlock() {
        // Proxy it.
        lock.unlock();
    }

    @Override
    public Condition newCondition() {
        // Proxy it.
        return lock.newCondition();
    }

    // Extra functionality to unlock from any thread.
    public void forceUnlock() {
        // Actually just replace the perhaps locked lock with a new one.
        // Kinda like a clone. I expect a neater way is around somewhere.
        if (lock instanceof ReentrantLock) {
            lock = new ReentrantLock();
        } else {
            throw new UnsupportedOperationException(
                "Cannot force unlock of lock type "
                    + lock.getClass().getSimpleName());
        }
    }
}