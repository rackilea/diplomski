public static Path write(Path path, byte[] bytes, OpenOption... options)
    throws IOException
{
    // ensure bytes is not null before opening file
    Objects.requireNonNull(bytes);

    try (OutputStream out = Files.newOutputStream(path, options)) {
        int len = bytes.length;
        int rem = len;
        while (rem > 0) {
            int n = Math.min(rem, BUFFER_SIZE);
            out.write(bytes, (len-rem), n);
            rem -= n;
        }
    }
    return path;
}