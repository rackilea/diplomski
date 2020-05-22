public synchronized boolean addWorkItem(Integer i) throws InterruptedException {
    while (queue.size() >= QUEUE_SIZE) {
        wait();
    }
    queue.addLast(i);
    notify();
    return true;
}