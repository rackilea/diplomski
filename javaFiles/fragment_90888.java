static <T> CompletableFuture<T> withFallback(CompletableFuture<T> future,
  BiFunction<CompletableFuture<T>, Throwable, ? extends CompletableFuture<T>>
                                                                      fallback) {
    return future.handle((response, error) -> error)
      .thenCompose(error -> error!=null? fallback.apply(future,error): future);
}