@Bean
public ApplicationRunner runner(MessageChannel input) {
    return args -> {
        while (true) {
            input.send(someMessage);
            Thread.sleep(1_000);
        }
    }
}