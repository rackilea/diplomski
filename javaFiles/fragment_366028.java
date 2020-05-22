public void scheduleAnimation(Animation a) {
    synchronized(this) {
        queue.add(a);
    }
}

public void waitQueueEmpty() throws InterruptedException {
    synchronized(this) {
        while (!queue.isEmpty()) {
            wait();
        }
    }
}