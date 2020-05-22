public static void main(String[] args) throws Exception {

    // Assume the file is in the computer's local encoding,
    // and specify the path to the file:
    Charset charset = Charset.defaultCharset();
    Path path = Paths.get("test.txt");

    // Read the lines of the file:
    List<String> lines = Files.readAllLines(path, charset);

    // Change the first line, replacing non-whitespace at the line's start:
    String header = lines.get(0);
    header = header.replaceFirst("^\\S+", "new");
    lines.set(0, header);

    // Write the lines to the file:
    Files.write(path, lines, charset);
}