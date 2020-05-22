String fileName = "..."; // use an actual file name :)
try (final FileReader fileReader = new FileReader(fileName);
            final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
    // try-with-resources idiom for auto-closing the readers
    String line = null;
    while ((line = bufferedReader.readLine()) != null) {
        // Here you can deal with the line
        // Caveat: the line breaks are stripped.
        // So now you don't know if it was \r, '\n or both.
        System.out.println("--> read a line: " + line);
    }
} catch (IOException e) {
    // You might throw it too, or use a logger. Just don't hide it silently
    // because that makes debugging difficult.
    e.printStackTrace();
}