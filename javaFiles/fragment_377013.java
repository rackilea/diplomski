public static void setVariable(int lineNumber, String data) throws IOException {
    Path path = Paths.get("data.txt");
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    lines.set(lineNumber - 1, data);
    Files.write(path, lines, StandardCharsets.UTF_8);
}