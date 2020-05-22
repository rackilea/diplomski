public void saveToFile(String fileToWrite) {
    List<String> lines = Arrays.asList(cardID, name, address);
    Path file = Paths.get(fileToWrite);
    try {
        Files.write(file, lines);
    } catch (IOException ex) {
        System.err.println("Error writing to " + file);
    }
}