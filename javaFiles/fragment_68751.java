try (Stream<Path> paths = Files.walk(dir)) {
    Stream<String> stream = paths.flatMap(p ->  {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    });
}