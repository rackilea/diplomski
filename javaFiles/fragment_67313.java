public void performWithLocking(String key, Runnable op) throws InterruptedException {
    while (true) {
        Object locker = new Object();
        Object o = concurrentMap.putIfAbsent(key, locker);
        if (o == locker) {
            try {
                op.run();
            } finally {
                // We want to lock even if the operation throws!
                synchronized (locker) {
                    locker.notifyAll(); // wake up everybody waiting.
                    concurrentMap.remove(key); // this has to be inside!
                }
            }
            return;
        } else {
            synchronized (o) {
                if (concurrentMap.containsKey(key)) o.wait();
                }
            }
        }
    }
}