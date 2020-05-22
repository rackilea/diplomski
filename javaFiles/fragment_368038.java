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
        return Mono.subscriberContext()
                   .filter(c -> c.hasKey("greetingWord"))
                   .map(c -> c.get("greetingWord"))
                   .flatMap(greetingWord -> Mono.just(greetingWord + " " + name + " " + "!!!"));// ALERT: we have Context here !!!
    }
}