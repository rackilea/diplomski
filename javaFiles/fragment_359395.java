public static void main(String[] args) throws IOException {
    String string = "This is lengthy string that contains many words. So\nI am wrapping it.";
    System.out.println(string);
    File file = new File("C:/Users/User/Desktop/text.txt");

    writeToFile(string, file);
}

private static void writeToFile(String string, File file) throws IOException {
    try (
        BufferedReader reader = new BufferedReader(new StringReader(string));
        PrintWriter writer = new PrintWriter(new FileWriter(file));
    ) {
        reader.lines().forEach(line -> writer.println(line));
    }
}