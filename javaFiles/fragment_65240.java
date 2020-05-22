public static <T> CompletableFuture<List<T>> join(List<CompletableFuture<T>> futures) {
    CompletableFuture[] cfs = futures.toArray(new CompletableFuture[futures.size()]);

    return CompletableFuture.allOf(cfs)
        .thenApply(v -> combineIndividualResults(c));
  }