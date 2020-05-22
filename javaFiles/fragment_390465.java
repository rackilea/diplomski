ExecutorService threadPool = Executors.newFixedThreadPool(10);
while (moreWork) {
    threadPool.submit(new MyClass);
}
// stop pool after you've submitted the last job, submitted jobs will still run
threadPool.shutdown();
// you can wait for the last job to finish if you'd like
threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);