Mono<Foo> myFoo =
        CacheMono.lookup(key -> Mono.justOrEmpty(myCache.getIfPresent(key))
                .map(Signal::next), id)
                .onCacheMissResume(() -> myService.fetch(id))
                .andWriteWith((key, signal) -> Mono.fromRunnable(() ->
                        Optional.ofNullable(signal.get())
                                .ifPresent(value -> myCache.put(key, value))));