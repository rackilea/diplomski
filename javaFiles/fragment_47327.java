public String getX() {
    Lock readLock = readWriteLock.readLock();
    readLock.lock();
    try {
        return value;
    } finally {
        readLock.unlock();
    }
}