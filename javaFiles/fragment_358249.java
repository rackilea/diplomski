public static <T> CompletableFuture<T> firstNonNull(List<CompletableFuture<T>> completableFutures) {

    final CompletableFuture<T> completableFutureResult = new CompletableFuture<>();
    completableFutures.forEach(cf -> cf.thenAccept(v -> {
        if (v != null) {
            completableFutureResult.complete(v);
        }
    }));
    return completableFutureResult;
}