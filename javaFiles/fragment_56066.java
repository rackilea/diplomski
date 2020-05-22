Pattern simpleWord = Pattern.compile("\\p{L}+"); // one or more Unicode letters
try (BufferedReader in = Files.newBufferedReader(Paths.get("path/to/file.txt"))) {
    for (String line; (line = in.readLine()) != null; ) {
        if (simpleWord.matcher(line).matches()) {
            // found simple word
        }
    }
}