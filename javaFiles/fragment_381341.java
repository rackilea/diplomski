class Consumer implements Runnable {
    private MyBoundedQueue<Integer> sharedQueue;

    public Consumer(MyBoundedQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("consumed: " + sharedQueue.take());
                Thread.sleep(50L);                        
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}