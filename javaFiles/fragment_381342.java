class Producer implements Runnable {
    private MyBoundedQueue<Integer> sharedQueue;

    public Producer(MyBoundedQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        try {
            for (int i = 0; i < 7; i++) {
                sharedQueue.put(i); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}