ParallelFlux<String> flux = Flux.range(1, 10).map(i -> i.toString()).parallel().runOn(Schedulers.elastic());

ParallelFlux<String> pipeline = flux.flatMap(s -> {
    Mono<String> async = BlockingRemoteCall.blockingMethodParallelThread(s);
    String r1 = async.block();
    return BlockingJournal.blockingMethodSingleThread(r1);
});

pipeline.sequential().doOnNext(System.out::println).blockLast();