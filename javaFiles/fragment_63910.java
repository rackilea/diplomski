public final class Test
{
    public static void main(final String... args)
        throws IOException
    {
        final Path zip = Paths.get("/home/fge/t.zip");

        final URI uri = URI.create("jar:" + zip.toUri());

        try (
            final FileSystem fs = FileSystems.newFileSystem(uri, Collections.emptyMap());
            final DirectoryStream<Path> stream = Files.newDirectoryStream(fs.getPath("/"));
        ) {
            for (final Path entry: stream)
                System.out.println(Files.size(entry));
        }
    }
}