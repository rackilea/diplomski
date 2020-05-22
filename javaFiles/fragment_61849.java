public synchronized Lock getLock(String id) {
    Lock lock = lockById.get(id);
    if (lock == null) {
        lock = new ReentrantLock(true);
        // put lock into the map so that next one will reuse it
        lockById.put(id, lock);
    }
    return lock;
}