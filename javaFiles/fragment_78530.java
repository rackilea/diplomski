ParallelFlux<String> flux1 = Flux.merge(source).parallel(1).concatMap(item -> Mono.fromCallable(() -> {
    Thread.sleep(1);
    return "1_" + counter1.incrementAndGet();
}).subscribeOn(Schedulers.fromExecutor(executor1)));

ParallelFlux<String> flux2 = Flux.merge(source).parallel(1024).concatMap(item -> Mono.fromCallable(() -> {
    Thread.sleep(100);
    return "2_" + counter2.incrementAndGet();
}).subscribeOn(Schedulers.fromExecutor(executor1)));