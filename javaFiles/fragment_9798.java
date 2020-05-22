for (String line: lines) {
    String[] words = line.split("\\s");

    if (words.length > 0 && words[0].equals(words[0].toUpperCase())) {
        ...
    }
}