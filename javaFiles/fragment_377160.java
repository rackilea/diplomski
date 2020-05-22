public static void shutdownPool(boolean awaitTermination) throws InterruptedException {

    //call shutdown to prevent new tasks from being submitted
    executor.shutdown();

    //get a reference to the Queue
    final BlockingQueue<Runnable> blockingQueue = executor.getQueue();

    //clear the Queue
    blockingQueue.clear();
    //or else copy its contents here with a while loop and remove()

    //wait for active tasks to be completed
    if (awaitTermination) {
        executor.awaitTermination(SHUTDOWN_TIMEOUT, TimeUnit.SECONDS);
    }
}