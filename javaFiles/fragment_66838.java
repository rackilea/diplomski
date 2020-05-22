class Dictionary {
    private final Set<String> rightWords;
    private final BiPredicate<String, Set<String>> lookupStrategy;

    Dictionary(Set<String> rightWords, BiPredicate<String, Set<String>> lookupStrategy) {
        // initialize private fields
    }

    boolean isRight(String word) {
        return lookupStrategy.test(word, rightWords);
    }
}