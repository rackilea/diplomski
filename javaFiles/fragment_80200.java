// I assume this is disposed properly etc
private static String getLastLine(BufferedReader reader) throws IOException {
    String line = null;
    String nextLine;
    while ((nextLine = reader.readLine()) != null) {
        line = nextLine;
    }
    return line;
}