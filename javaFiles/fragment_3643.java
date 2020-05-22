AtomicInteger counter = new AtomicInteger();

ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
    ForkJoinWorkerThread thread =
        ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);

    thread.setName("user6778654-" + counter.incrementAndGet());

    return thread;
};

CompletableFuture<Void> future = CompletableFuture.runAsync(task,
    new ForkJoinPool(Runtime.getRuntime().availableProcessors(),
        factory, null, false));

}