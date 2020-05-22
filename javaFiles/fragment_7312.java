ExecutorService taskExecutor = Executors.newFixedThreadPool(noOfParallelThreads);
while(...) {
  taskExecutor.execute(new downloadImage());
}
taskExecutor.shutdown();
try {
  taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
} catch (InterruptedException e) {
  ...
}