public static <T> Map collectMany(List<T> data, Function<T, ?>... groupers) {
    Collector collector = Collectors.groupingBy(groupers[groupers.length-1]);
    for (int i = groupers.length - 2; i >= 0; i--) {
        collector = Collectors.groupingBy(groupers[i], collector);
    }
    return (Map) data.stream().collect(collector);
}