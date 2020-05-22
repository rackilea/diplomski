private static <T> Stream<T> progressiveFilter(Stream<T> stream,
                                               BiPredicate<T, T> predicate) {
    List<T> list = stream.collect(Collectors.toList());
    List<T> result = new ArrayList<>();
    T previousValue = null;
    for (T entry : list) {
        if (previousValue == null) {
            previousValue = entry;
        } else {
            if (predicate.test(entry, previousValue)) {
                result.add(previousValue);
            } else {
                previousValue = entry;
            }
        }
    }
    if(previousValue != null) {
        result.add(previousValue);
    }
    return result.stream();
}