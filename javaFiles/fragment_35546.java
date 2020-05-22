PriorityBlockingQueue<Runnable> q = new PriorityBlockingQueue<>(11 /*default*/,
        new CFRunnableComparator());
ThreadPoolExecutor pool = new ThreadPoolExecutor(..., q);
CompletableFuture.supplyAsync(new PrioritySupplier<>(n, () -> {
    ...
}), pool);