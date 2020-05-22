public static <T> CompletableFuture<T> anyMatch(
    List<? extends CompletionStage<? extends T>> l, Predicate<? super T> criteria) {

    CompletableFuture<T> result=new CompletableFuture<>();
    Consumer<T> whenMatching=v -> { if(criteria.test(v)) result.complete(v); };
    CompletableFuture.allOf(l.stream()
        .map(f -> f.thenAccept(whenMatching)).toArray(CompletableFuture<?>[]::new))
    .whenComplete((ignored, t) ->
        result.completeExceptionally(t!=null? t: new NoSuchElementException()));
    return result;
}