private List<Path> getInputFiles(final String baseDir, final int counter)
{
    final Path path = Paths.get(baseDir);
    final List<Path> result = new ArrayList<>();
    final DirectoryStream.Filter<Path> filter
        = new MyFilter(counter);

    try (
        final DirectoryStream<Path> stream = Files.newDirectoryStream(path, filter);
    ) {
        for (final Path entry: stream)
            result.add(entry);
    }

    return result;
}