enum LookupStrategy implements BiPredicate<String, Set<String>> {
    FAST_LOOKUP {
        @Override public boolean test(String word, Set<String> rightWords) {
            return rightWords.contains(word);
        }
    },
    SLOW_LOOKUP {
        @Override public boolean test(String word, Set<String> rightWords) { ... }
    }
}