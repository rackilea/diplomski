final Path dstFile = Paths.get("your/destination/file");

final OutputStream out = Files.newOutputStream(dstFile);

final ThrowingConsumer<Path> copy = path -> Files.copy(path, out);

try (
    final OutputStream outref = out;
) {
    Stream.of("file1", "file2").map(Paths::get).forEach(copy);
}