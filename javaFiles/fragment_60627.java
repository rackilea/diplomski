public String getFilePath(InputStream inputStream, String prefix, String suffix)
        throws IOException
{
    java.nio.file.Path p = java.nio.file.Files.createTempFile(prefix, suffix);
    p.toFile().deleteOnExit();
    java.nio.file.Files.copy(inputStream, p, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    return p.toAbsolutePath().toString();
}