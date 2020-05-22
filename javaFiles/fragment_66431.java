BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
ThreadPoolExecutor executorService =
     new ThreadPoolExecutor(1, 3, 30, TimeUnit.SECONDS, arrayBlockingQueue);
// when the blocking queue is full, this tries to put into the queue which blocks
executorService.setRejectedExecutionHandler(new RejectedExecutionHandler() {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            // block until there's room
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RejectedExecutionException("Producer thread interrupted", e);
        }
    }
});