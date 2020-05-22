@PreDestroy
    public void cleanUp() throws InterruptedException {
        scheduleExecutorService.shutdown();
        try {
            scheduleExecutorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            scheduleExecutorService.shutdownNow();
            throw e;
        }
    }