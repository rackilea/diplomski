public static <T, R> Optional<R> findFirstNonNull(Collection<T> objects, 
                                                  Function<T, R> getter) {
    return objects.stream()
            .filter(Objects::nonNull)
            .map(getter)
            .filter(Objects::nonNull)
            .findFirst();
}