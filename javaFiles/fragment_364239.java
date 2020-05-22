List<String> items = ...
ConcurrentMap<String, String> resultsByItem = new ConcurrentHashMap<>();

Future<Void> allWork = CompletableFuture.allOf(
    items.stream()
        .map(item -> someWork(item) // Get a completable future for this item
                     .andThen(result -> resultsByItem.put(item, result)) // Append the result to the map
        ).toArray(CompletableFuture[]::new)
);
allWork.join();
// Your futureMap is completed.