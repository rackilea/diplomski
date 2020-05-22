public static FileSystem getZipFileSystem(final String zipPath)
{
    final Path path = Paths.get(zipPath).toAbsolutePath();
    final Map<String, Object> env = new HashMap<>();
    final URI uri = URI.create("jar:file:" + path.toString());
    return FileSystems.newFileSystem(uri, env, null);
}