if (predicate == WORDS_OF_ODD_LENGTH || predicate == WORDS_OF_EVEN_LENGTH) {
    // assume if the first word in a list of words of the same length
    // then take all words of that length.
    return wordsBySize.values().stream()
                               .filter(l -> predicate.test(l.get(0)))
                               .flatMap(l -> l.stream()).collect(toList());
} else {
    return wordsBySize.values().stream()
                               .flatMap(l -> l.stream())
                               .filter(predicate)
                               .collect(toList());
}