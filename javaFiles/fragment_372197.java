public static <T> Map collectMany(List<T> data, Function<T, ?>... groupers) {
    Iterator<Function<T, ?>> iter = Arrays.asList(groupers).iterator();
    Collector collector = Collectors.groupingBy(iter.next());
    while (iter.hasNext()) {
        collector = Collectors.groupingBy(iter.next(), collector);
    }
    return (Map) data.stream().collect(collector);
}