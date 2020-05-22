public Path downloadFile(final Path dir, final URL url)
    throws IOException
{
    final String filename = /* decide about the filename here */;
    final Path ret = dir.resolve(filename);

    try (
        final InputStream in = url.openStream();
    ) {
        Files.copy(in, ret);
    }

    return ret;
}