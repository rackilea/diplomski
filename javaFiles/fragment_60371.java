ReentrantLock lock = new ReentrantLock();

public String refreshToken() {
    if (lock.tryLock()) {
        readWriteLock.writeLock().lock();
        try {
            // fetch session from server and store on disk
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    return readToken();
}