public static void main(String[] args) {
    // So we have a list of ids, I stream it
    // (note : if we have an iterator, you could group it by a batch of, say 100,
    // and then flat map each batch)
    LongStream ids = LongStream.range(0, 10_000_000L);
    // This is were the actual tasks will be dispatched
    ExecutorService executor = Executors.newFixedThreadPool(4);

    // For each id to compute, create a runnable, which I call "WorkUnit"
    Optional<Exception> error = ids.mapToObj(WorkUnit::new)
             // create a parralel stream
             // this allows the stream engine to launch the next instructions concurrently
            .parallel()
            // We dispatch ("parallely") the work units to a thread and have them execute
            .map(workUnit -> CompletableFuture.runAsync(workUnit, executor))
            // And then we wait for the unit of work to complete
            .map(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    // we do care about exceptions
                    return e;
                } finally {
                    System.out.println("Done with a work unit ");
                }
                // we do not care for the result
                return null;
            })
            // Keep exceptions on the stream
            .filter(Objects::nonNull)
            // Stop as soon as one is found
            .findFirst();


    executor.shutdown();
    System.out.println(error.isPresent());
}