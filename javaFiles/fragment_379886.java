//the first upstream is always blocked.
CompletableFuture<String> blocked = new CompletableFuture<>();
CompletableFuture<String> upstreams = Stream.of(cf1, cf2, cf3, cf4).reduce(blocked,
        (it, upstream) -> it.applyToEither(upstream, Function.identity()));

upstreams.thenAccept(System.out::println).join();// print "foo"