final Path path = Paths.get(System.getProperty("user.home"),
    "Desktop", "yourFileName");

try (
    final BufferedWriter writer = Files.newBufferedWriter(path,
        StandardCharsets.UTF_8, StandardOpenOption.APPEND);
) {
    // use the writer here
}