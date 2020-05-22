final Path baseDir = Paths.get("path/to/dir");

final List<Path> tenFirstEntries = new ArrayList<>(10);

final DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>()
{
    @Override
    public boolean accept(final Path entry)
    {
        return entry.getFileName().endsWith(".processed")
            && Files.isRegularFile(entry);
    }
};

try (
    final DirectoryStream<Path> stream 
        = Files.newDirectoryStream(baseDir, filter);
) {
    final Iterator<Path> iterator = stream.iterator();
    for (int i = 0; iterator.hasNext() && i < 10; i++)
        tenFirstEntries.add(iterator.next());
}