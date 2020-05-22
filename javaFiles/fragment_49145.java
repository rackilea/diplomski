public static void main(String... args) {
    Task task = sync(
        wrap(() -> log("1")),
        async(
            wrap(() -> log("A")),
            wrap(() -> log("B")),
            wrap(() -> log("C"))),
        wrap(() -> log("2")),
        wrap(() -> log("3")));
    ExecutorService executor = Executors.newFixedThreadPool(4);
    task.execute(CompletableFuture.completedFuture(null), executor).join();
    executor.shutdown();
}