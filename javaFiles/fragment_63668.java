try (InputStream is = Files.newInputStream(path, StandardOpenOption.READ)) {
    InputStreamReader reader = new InputStreamReader(is, fileEncoding);
    BufferedReader lineReader = new BufferedReader(reader);
    // Process all lines.
    String line;
    while ((line = lineReader.readLine()) != null) {
        // Line content content is in variable line.
    }
}