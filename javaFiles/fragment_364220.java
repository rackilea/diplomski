static Spliterator<String> createCollatzRandomSpliterator() {
    return new Random()
            .ints(1, 1_000_000) // unbound!
            .flatMap(nr -> collatzSequence(nr))
            .mapToObj(Integer::toString)
            .spliterator();
}

static String findGoodNumberWithSpliterator() {
    Spliterator<String> source = createCollatzRandomSpliterator();

    String[] res = new String[1]; // work around for "final" closure restriction

    while (source.tryAdvance(s -> {
        if (s.contains("123")) {
            res[0] = s;
        }
    })) {
        if (res[0] != null)
            return res[0];
    }
    throw new IllegalStateException("Impossible");
}