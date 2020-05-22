CompletableFuture<String> cf1 = supplyAsync(blocked(String.class));
CompletableFuture<String> cf2 = supplyAsync(returnValueLater("bar"));
CompletableFuture<String> cf3 = supplyAsync(blocked(String.class));
CompletableFuture<String> cf4 = supplyAsync(returnValue("foo"));

CompletableFuture<String> upstreams = cf1.applyToEither(cf2, Function.identity())
                                         .applyToEither(cf3, Function.identity())
                                         .applyToEither(cf4, Function.identity());

upstreams.thenAccept(System.out::println).join();// print "foo"

private <T> Supplier<T> returnValue(T value) {
    return returnValue(() -> value);
}

private <T> Supplier<T> blocked(Class<T> type) {
    return returnValue(() -> {
        Thread.currentThread().join();
        return null;
    });
}

private <T> Supplier<T> returnValueLater(T value) {
    return returnValue(() -> {
        Thread.sleep(100);
        return value;
    });
}

private <T> Supplier<T> returnValue(Callable<T> value) {
    return () -> {
        try {
            return value.call();
        } catch (Exception e) { throw new RuntimeException(e); }
    };
}