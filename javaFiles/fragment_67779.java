public static void main(String[] args) throws IOException {

    String countryStr = new String(readTextFile("src/data/countryToParse.sql"), "UTF-8");
    writeToTextFile("src/data/countryParsed.sql", countryStr);
}

public static byte[] readTextFile(String fileName) throws IOException {
    return Files.readAllBytes(Paths.get(fileName));
}