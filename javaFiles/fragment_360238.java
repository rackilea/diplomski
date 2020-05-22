public static String findSimilarity(String word, List<String> candidatesList) {

    // Populating the set with distinct values of the input terms
    Set<String> candidates = candidatesList.stream()
            .map(String::toLowerCase)
            .map(term -> Arrays.stream(term.split(" ")).sorted().collect(Collectors.joining(" "))) // eliminates permutations
            .collect(Collectors.toSet());

    Map<String, Integer> cache = new ConcurrentHashMap<>();

    return candidates.parallelStream()
            .map(String::trim)
                    // add more mappers if needed
            .filter(s -> !s.equalsIgnoreCase(word))
                    // add more filters if needed
            .min((a, b) -> Integer.compare(
                    cache.computeIfAbsent(a, k -> getLevenshteinDistance(word, k)),
                    cache.computeIfAbsent(b, k -> getLevenshteinDistance(word, k))))
            .get(); // get the closest match
}