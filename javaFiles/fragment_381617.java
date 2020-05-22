public static void main(final String[] args) throws Exception {
    final Path path = Paths.get("path", "to", "file.tsv");
    final List<Bean> parsed;
    try (final Stream<String> lines = Files.lines(path)) {
        parsed = lines.skip(1).map(line -> line.split("\\s*\\|\\s*")).map(line -> {
            final int id = Integer.parseInt(line[0]);
            final String name = line[1];
            final List<Integer> types = Arrays.stream(line).
                    skip(2).map(t -> Integer.parseInt(t.replaceAll("\\D", ""))).
                    collect(Collectors.toList());
            return new Bean(id, name, types);
        }).collect(Collectors.toList());
    }
}