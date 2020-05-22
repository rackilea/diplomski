// Choose appropriate charset; but you SHOULD use UTF-8 in 2014.
final Charset charset = StandardCharsets.UTF_8;
final CopyOption replace = StandardCopyOption.REPLACE_EXISTING;
final CopyOption atomic = StandardCopyOption.ATOMIC_MOVE;

final Path origin = Paths.get("a.txt").toAbsolutePath();
final Path tmpfile = Files.createTempFile(origin.getParent(), "tmp", "tmp");

try (
    final BufferedReader reader = Files.newBufferedReader(origin, charset);
    final BufferedWriter writer = Files.newbufferedWriter(tmpfile, charset);
) {
    // manipulate contents: read from the reader, write to the writer
} // CAN FAIL HERE; if it does, DO NOT catch and just printStackTrace()

// finally, rename
try {
    Files.move(tmpfile, origin, replace, atomic);
} catch (AtomicMoveNotSupportedException ignored) {
    Files.move(tmpfile, origin, replace);
}