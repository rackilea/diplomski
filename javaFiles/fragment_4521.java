public static <T, S> Predicate<T> extractThenFilter(
        Function<T, S> extractor, 
        Predicate<S> condition) {

    return t -> condition.test(extractor.apply(t));
}

public static <T> Predicate<T> and(Predicate<T>... conditions) {
    return Arrays.stream(conditions)
        .reduce(Predicate::and)
        .orElse(t -> true);
}