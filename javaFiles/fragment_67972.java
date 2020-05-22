final BufferedReader reader;
final BufferedWriter writer;
String line;

try (
    reader = Files.newBufferedReader(src, StandardCharsets.UTF_8);
    writer = Files.newBufferedWriter(dst, StandardCharsets.UTF_8);
) {
    while ((line = reader.readLine()) != null) {
        doSomethingWith(line);
        writer.write(line);
        // must do this: .readLine() will have stripped line endings
        writer.newLine();
    }
}