protected void pendingTaskStarter() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(maxThreadNum);

    for (int i = 0; i < maxThreadNum; i++) {
        service.submit(new PendingTaskConsumer());
    }

    // Shutdown service.
    // This will continue to process already submitted tasks.
    service.shutdown();

    try {
        // wait at least 5 minutes for the tasks to complete
        if (!service.awaitTermination(5, TimeUnit.MINUTES)) {
            // still not done yet -> force shutdown
            // this will interrupt currently running tasks.
            service.shutdownNow();
        }
    } catch (InterruptedException ex) {
        // someone interrupted this thread. Shutdown tasks immediately
        service.shutdownNow();
        // propagate exception
        throw ex;
    }
}