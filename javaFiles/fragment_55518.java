// create a thread pool with as many workers as needed
ExecutorService threadPool = Executors.newCachedThreadPool();
// submit your jobs which should implements Runnable
for (YourRunnable job : jobs) {
    threadPool.submit(job);
}