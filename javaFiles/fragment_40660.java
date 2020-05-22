public <T> List<T> buildGroup(
        Collection<? extends T> entities,
        Function<? super T, Integer> property,
        int from, int to, int sum
) {
    return entities.stream()
            .filter(elm -> isPropertyMatch(property.apply(elm), from, to, sum))
            .sorted(Comparator.comparing(property))
            .collect(Collectors.toList());
}