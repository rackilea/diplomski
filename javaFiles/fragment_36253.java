private static int countWords(String sentence, List<String> targets) {
    String[] words = sentence.split(" ");
    return Stream.of(words)
            .map(String::toUpperCase)
            .map(word -> targets.stream().filter(word::contains).count())
            .reduce(0L, Long::sum)
            .intValue();
}