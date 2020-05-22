public static <E> String loop(Collection<E> collection) {
    return collection.stream()
        .map(Object::toString)
        .reduce((a, b) -> a + b)
        .get();
}