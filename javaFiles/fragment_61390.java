final Path baseDir = Paths.get("path/to/dir");

final List<Path> tenFirstEntries;

final BiPredicate<Path, BasicFileAttributes> predicate = (path, attrs)
    -> attrs.isRegularFile() && path.getFileName().endsWith(".processed");

try (
    final Stream<Path> stream = Files.find(baseDir, 1, predicate);
) {
    tenFirstEntries = stream.limit(10L).collect(Collectors.toList());
}