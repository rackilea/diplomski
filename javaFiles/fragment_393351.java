enum CollectionType implements Predicate<String> {
    WORDS_OF_ODD_LENGTH(s -> s.length() % 2 != 0),
    WORDS_OF_EVEN_LENGTH(WORDS_OF_ODD_LENGTH.negate()),
    STARTING_WITH_VOWEL(s -> isVowel(s.charAt(0))),
    STARTING_WITH_CONSONANT(STARTING_WITH_VOWEL.negate()),
    COMPLEX_CHECK(CollectionType::complexCheck);

    private final Predicate<String> predicate;

    CollectionType(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }

    public boolean test(String s) {
        return predicate.test(s);
    }

    public static boolean complexCheck(String s) {
        // many lines of code, calling many methods
    }
}