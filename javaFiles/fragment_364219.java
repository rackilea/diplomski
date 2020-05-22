static String findGoodNumber() {
    return new Random()
            .ints(1, 1_000_000) // unbound!
            .flatMap(nr -> collatzSequence(nr))
            .mapToObj(Integer::toString)
            .filter(s -> s.contains("123"))
            .findFirst().get();
}