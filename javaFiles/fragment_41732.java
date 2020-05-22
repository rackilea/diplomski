private static final Pattern SPACES = Pattern.compile("[^a-zA-Z]+");

public static Stream<String> getWordStream(String path) throws IOException{
    return Files.lines(Paths.get(path))
        .flatMap(SPACES::splitAsStream)
        .filter(word -> word.length() >= 3);
}