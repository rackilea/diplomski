// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// define your jobs somehow
for (MyRunnable job : jobsToDo) {
    threadPool.submit(job);
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();