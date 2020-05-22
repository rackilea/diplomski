private static String readLineAtOffset(String fileName, int offsetNum) throws IOException {
    int count = 0;
    StringBuilder line = new StringBuilder();
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
        for (int ch; (ch = reader.read()) != -1; count++) {
            if (ch != '\r' && ch != '\n')
                line.append((char)ch);
            else if (count < offsetNum)
                line.setLength(0);
            else
                break;
        }
    }
    return (count >= offsetNum ? line.toString() : null);
}