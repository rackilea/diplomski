CountDownLatch latch = new CountDownLatch(totalNumberOfImageDownloadTasks);
ExecutorService taskExecutor = Executors.newFixedThreadPool(noOfParallelThreads);
while(...) {
  taskExecutor.execute(new downloadImage());
}

try {
  latch.await();
} catch (InterruptedException E) {
   // handle
}