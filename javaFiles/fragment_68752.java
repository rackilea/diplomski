try (Stream<Path> paths = Files.walk(dir)) {
    IntStream stream = paths.flatMapToInt(p ->  {
        try {
            return Files.lines(p).mapToInt(String::length);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    });
}