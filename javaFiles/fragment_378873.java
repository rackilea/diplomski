public synchronized boolean addWorkItem(Integer i) throws InterruptedException {
    final long maxWaitTime = 60L * 1000;
    long totalWaitTime = 0;
    while (queue.size() >= QUEUE_SIZE && totalWaitTime <= maxWaitTime) {
        long waitStartTime = System.currentTimeMillis();
        wait(maxWaitTime);
        totalWaitTime += (System.currentTimeMillis() - waitStartTime);
    }
    if (queue.size() >= QUEUE_SIZE) {
        return false;
    }
    queue.addLast(i);
    notify();
    return true;
}