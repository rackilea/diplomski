public Flux<Integer> createFlux() {
    return Flux.<List<Integer>>generate(sink -> {
        sink.next(Arrays.asList(1, 2, 3));
    })
            .take(Duration.ofSeconds(10))
            .flatMap(Flux::fromIterable);
}

@Test
public void so44657525() throws InterruptedException {
    Scheduler scheduler = Schedulers.newSingle("test");
    AtomicInteger adder = new AtomicInteger();

    StepVerifier.withVirtualTime(() -> createFlux()
            .subscribeOn(scheduler)
            .doOnNext(v -> adder.incrementAndGet())
    )
                .expectNextCount(1)
                .thenAwait(Duration.ofSeconds(10))
                .thenConsumeWhile(t -> true)
                .verifyComplete();

    System.out.println("Total number of values in generated lists: " + adder.get());
}