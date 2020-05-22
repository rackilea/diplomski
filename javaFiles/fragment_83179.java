private static final BiPredicate<Path, BasicFileAttributes> ONLINE_DIRS 
    = (path, attrs) -> attrs.isDirectory() 
    && path.getFileName().toString().equals("online");

// ...

final Path baseDir = Paths.get(...);
final List<Path> dirList;

try (
    final Stream<Path> stream = Files.find(baseDir, Integer.MAX_VALUE,
        ONLINE_DIRS);
) {
    dirList = stream.collect(Collectors.toList());
}