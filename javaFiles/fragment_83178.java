public final class DirectoryCollectorVisitor
    extends SimpleFileVisitor<Path>
{
    private final List<Path> list;

    public DirectoryCollectorVisitor(final List<Path> list)
    {
        this.list = list;
    }

    @Override
    public FileVisitResult previsitDirectory(final Path path, final BasicFileAttributes attrs)
    {
        if (path.getFileName().toString().equals("online"))
            list.add(path);
        return FileVisitResult.CONTINUE;
    }
}

// ...

final Path baseDir = Paths.get(...);
final List<Path> dirList = new ArrayList<>();
final FileVisitor<Path> visitor = new DirectoryCollectorVisitor(list);
Files.walkFileTree(baseDir, visitor);
// dirList is not filled with the entries