public class TestFlatMap {
    public static void main(final String ...args) {
        final Flux<String> greetings = Flux.just("Hubert", "Sharon")
                                           .flatMap(TestFlatMap::nameToGreeting)
                                           .subscriberContext(context ->
                                                   Context.of("greetingWord", "Hello")  // context initialized
                                           );
        greetings.subscribe(System.out::println);
    }

    private static Mono<String> nameToGreeting(final String name) {
        return Mono.zip(
            Mono.subscriberContext()
                .filter(c -> c.hasKey("greetingWord"))
                .map(c -> c.get("greetingWord")), // ALERT: we have Context here !!!
            Mono.just(name),
            (greetingWord, receivedName) -> greetingWord + " " + receivedName + " " + "!!!"
        );
    }
}