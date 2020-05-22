ReplayProcessor<Integer> directProcessor = ReplayProcessor.cacheLast();

    Flux.range(1, 10)
            .map(integer -> {
                directProcessor.onNext(integer);
                return integer;
            }).doOnComplete(() -> {
        directProcessor.subscribe(System.out::println);
        directProcessor.subscribe(System.out::println);
    })
            .subscribe();