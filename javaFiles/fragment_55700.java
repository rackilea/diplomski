static <T> Stream<T> symmetricDifference(Stream<T> stream1, Stream<T> stream2) {
    Set<T> elements1 = stream1.collect(Collectors.toSet());
    Set<T> elements2 = stream2.collect(Collectors.toSet());
    Set<T> result = new HashSet<T>(elements1);
    result.addAll(elements2);
    elements1.retainAll(elements2);
    result.removeAll(elements1);
    return result.stream();
}