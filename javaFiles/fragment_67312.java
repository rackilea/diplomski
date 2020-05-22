public void doWithLocking(String key, Runnable op) {
    Object locker = new Object();
    Object o = concurrentMap.putIfAbsent(key, locker);
    if (o == locker) {
        op.run();
        synchronized (locker) {
            locker.notifyAll(); // wake up everybody waiting.
            concurrentMap.remove(key); // this has to be inside!
        }
    } else {
        ...
    }
}