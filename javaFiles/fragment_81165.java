public static List<String[]> read(Path path) throws IOException {
    try (Stream<String> lines = Files.lines(path)) {
        return lines
                .map(e -> e.split(","))
                .collect(Collectors.toList());
    }
}