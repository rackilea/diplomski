public static <T> CompletableFuture<T> firstNonNull(List<CompletableFuture<T>> completableFutures, T defaultValue) {

    final CompletableFuture<T> completableFutureResult = new CompletableFuture<>();
    completableFutures.forEach(cf -> cf.thenAccept(v -> {
        if (v != null) {
            completableFutureResult.complete(v);
        }
    }));
    //handling the situation where all the CFs returned null 
    CompletableFuture<Void> allCompleted = CompletableFuture
        .allOf((CompletableFuture<?>[]) completableFutures.toArray());
    allCompleted.thenRun(() -> {
        //checking first if any of the completed delivered a non-null value, to avoid race conditions with the block above 
        completableFutures.forEach(cf -> {
            final T result = cf.join();
            if (result != null) {
                completableFutureResult.complete(result);
            }
        });
        //if still not completed, completing with default value
        if ( !completableFutureResult.isDone()) {
            completableFutureResult.complete(defaultValue);
        }
    });
    return completableFutureResult;
}