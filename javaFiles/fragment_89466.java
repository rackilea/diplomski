@Bean
List<Topic> topics(
        final Environment environment,
        final ObjectMapper objectMapper) throws IOException {
    // Get the file path
    final var topicsPath = environment.getProperty("topicsPath");

    if (topicsPath == null) {
        return Collections.emptyList();
    }

    // Read the file content
    final var json = Files.readString(Paths.get(topicsPath));

    // Convert the JSON to Java objects
    final var topics = objectMapper.readValue(json, Topic[].class);
    return Arrays.asList(topics);
}