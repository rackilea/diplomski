public static void main(String[] args) {
    Mono<Integer> m = Mono.just(1);

    m.flatMap(a -> Mono.delay(Duration.ofMillis(5000)).flatMap(p -> Mono.empty()))
     .switchIfEmpty(getFallback())
     .doOnNext(a -> System.out.println(a))
     .block();
}

private static Mono<Integer> getFallback() {
    System.out.println("Assembly time, here we are just in the process of creating the mono but not triggering it. This is always called regardless of the emptiness of the parent Mono.");
    return Mono.fromCallable(() -> {
        System.out.println("Subscription time, this is the moment when the publisher got subscribed. It is got called only when the Mono was empty and fallback needed.");
        return 5;
    });
}