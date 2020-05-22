private static int countWords(String sentence, List<String> targets) {
    String[] words = sentence.split(" ");
    return (int) Stream.of(words)
            .map(String::toUpperCase)
            .filter(word -> targets.stream().anyMatch(word::contains))
            .count();
}