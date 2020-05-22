public static BufferedReader getBufferedReader(String fileToFind,
                                               ClassLoader classLoader) {
    InputStream inputStream = classLoader.getResourceAsStream(fileToFind);
    InputStreamReader streamReader = new InputStreamReader(inputStream,
        StandardCharsets.UTF_8);
    return new BufferedReader(streamReader);
}