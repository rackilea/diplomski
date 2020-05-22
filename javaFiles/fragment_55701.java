static <T> Stream<T> disjointStream(Stream<T> stream1, Stream<T> stream2) {
    Set<T> elements1 = stream1.collect(Collectors.toSet());
    Set<T> elements2 = stream2.collect(Collectors.toSet());
    Set<T> elementsIn1Notin2 = elements1.stream().filter(t -> !elements2.stream().anyMatch(Predicate.isEqual(t))).collect(Collectors.toSet());
    Set<T> elementsIn2Notin1 = elements2.stream().filter(t -> !elements1.stream().anyMatch(Predicate.isEqual(t))).collect(Collectors.toSet());
    return Stream.concat(elementsIn1Notin2.stream(), elementsIn2Notin1.stream());
}