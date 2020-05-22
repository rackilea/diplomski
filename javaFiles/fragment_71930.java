try (Scanner in = new Scanner(Paths.get(INFILE), "UTF-8")) {
    String line;
    while ((line = in.findWithinHorizon(pat, 0)) != null) {
        // Process the line, then write the output using something like
        // FileWriter.write(String) that doesn't add another line terminator.
    }
}