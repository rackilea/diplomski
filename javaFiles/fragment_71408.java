Set<CompletableFuture<String>> futures = service.getSomething();
futures.forEach(future -> future.whenComplete(
        (result, throwable) -> System.out.println(result)
));

CompletableFuture
    .allOf(futures.toArray(new CompletableFuture[0]))
    .join();