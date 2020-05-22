// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// define your jobs somehow
for (MyCallable job : jobsToDo) {
    // under the covers this creates a FutureTask instance
    Future future = threadPool.submit(job);
    // save the future if necessary in a collection or something
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
// now we can go back and call `future.get()` to get the results from our jobs