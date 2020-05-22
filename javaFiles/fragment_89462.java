@Bean
@Qualifier("topics")
List<String> topics(final Environment environment) {
    final var topics = environment.getProperty("topics", "");
    return Arrays.asList(topics.split(","));
}