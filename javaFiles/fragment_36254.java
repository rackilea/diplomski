private static String replaceWordsWithAsterisks(String sentence, List<String> targets) {
    String[] words = sentence.split(" ");
    List<String> processedWords = Stream.of(words)
            .map(word -> targets.stream().anyMatch(word.toUpperCase()::contains) ? "***" : word)
            .collect(Collectors.toList());

    return String.join(" ", processedWords);
}