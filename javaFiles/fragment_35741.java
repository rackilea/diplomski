public static CompletableFuture<List<Object>> myAllOf(CompletableFuture<?>... futures) {
     return CompletableFuture.allOf(futures)
            .thenApply(x -> Arrays.stream(futures)
                    .map(f -> (Object) f.join())
                    .collect(toList())
            );
}