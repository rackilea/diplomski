Lock getLock(String key) {
    Lock lock = lockMap.get(key);
    if (lock == null) {
        lock = new ReentrantLock();
        Lock race = lockMap.putIfAbsent(key, lock);
        if (race != null) {
            //there was a race, we lost.
            lock = race;
        }
    }
    return lock;
}