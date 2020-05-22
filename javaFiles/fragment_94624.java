ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
    60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(MAX_QUEUE_SIZE));
// need to say what to do if the queue is full
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
     public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
          // this will block the caller if the queue is full
          executor.getQueue().put(r);
     }
});