List<String> getAllLines(File file, Charset... charsets) {
    for (Charset cs: charsets) {
        try {
            return Files.readAllLines(file.toPath(), cs);
        } catch (MalformedInputException e) {
            ...
        } catch (IOException e) {
            ...
        }
    }
    // error
}