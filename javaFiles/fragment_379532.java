final Path path = Paths.get("file.txt");

try (
    final BufferedReader reader = Files.newBufferedReader(path,
        StandardCharsets.UTF_8);
) {
    String line;
    byte[] bytes;
    while ((line = reader.readLine()) != null) {
        bytes = line.getBytes(Charset.forName("cp850"));
        // write this method
        dumpBytes(bytes);
    }
}