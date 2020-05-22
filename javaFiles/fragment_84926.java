public static void main(String[] args) {
    Mono<Integer> m = Mono.just(1);
    m.flatMap(a -> Mono.delay(Duration.ofMillis(5000)).flatMap(p -> Mono.empty()))
     .switchIfEmpty(Mono.defer(() -> getFallback()))
     .doOnNext(a -> System.out.println(a))
     .block();
}

private static Mono<Integer> getFallback() {
    System.out.println("Since we are using Mono.defer in the above pipeline, this message gets logged at subscription time.");
    return Mono.just(5);
}