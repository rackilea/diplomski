// start a thread pool with 3 worker threads and a queue of 100
ExecutorService threadPool =
      new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
                             new ArrayBlockingQueue<Runnable>(100));
// to get the producer to _block_ instead of rejecting the job you need a handler
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
     public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
         // this will cause the producer to block until there is room in queue
         executor.getQueue().add(r);
     }
});