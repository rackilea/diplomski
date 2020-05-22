public static <T1, T2, T3, R> CompletableFuture<R> combine3Future(
        CompletableFuture<T1> future1,
        CompletableFuture<T2> future2,
        CompletableFuture<T3> future3,
        TriFunction<T1, T2, T3, R> fn
) {
    return future1.thenCombine(future2, Pair::new)
            .thenCombine(future3, (pair, t3) -> fn.apply(pair.getKey(), pair.getValue(), t3));
}