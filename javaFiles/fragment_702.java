CompletableFuture<Integer> foo1(String str) {
    return CompletableFuture.supplyAsync(() -> foo2(str))
            .thenApply(foo2Result -> {
                        foo3(str);
                        return foo2Result;
                    }
            );
}