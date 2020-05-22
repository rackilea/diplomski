public static int countCharacterOutsideQuotes(Reader reader, char targetChar) throws IOException {
    Objects.requireNonNull(reader);
    int count = 0;
    boolean isQuoted = false;
    // using `charAt` avoids doubling memory usage of copying all the chars into another array
    for (int c = reader.read(); c != -1; c = reader.read()) {
        if (c == '"') {
            // found a quote, flip from not quoted to quoted or vice versa.
            isQuoted = !isQuoted;
        } else if (c == targetChar && !isQuoted) {
            // found the target character, if it's not inside quotes then count it
            count++;
        }
    }
    return count;
}

public static void main(String[] args) {
    // try (Reader reader = new InputStreamReader(new StringReader("your-test-string-goes-here"));) {
    try (Reader reader = new InputStreamReader(new FileInputStream("/path/to/file.txt"));) {
        System.out.println(countCharacterOutsideQuotes(reader, '{'));
    } catch (IOException e) {
        e.printStackTrace();
    }
}