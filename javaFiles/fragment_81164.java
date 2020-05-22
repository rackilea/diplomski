public static void write(List<String[]> items, Path path) throws IOException {
    List<String> lines = items.stream()
            .map(row -> String.join(",", row))
            .collect(Collectors.toList());
    Files.write(path, lines);
}