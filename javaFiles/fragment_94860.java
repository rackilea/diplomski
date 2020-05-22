public static Map<String, List<Foo>> mapByCriteria(List<Foo> fooList, Group criteria) {
    Function<Foo, String> simpleKeyCriteria;
    switch(criteria) {
        case CASSETTE: simpleKeyCriteria = Foo::getCassette; break;
        case DATE: simpleKeyCriteria = p -> p.getDate().toString(); break;
        case ORGAN:
            return fooList.stream()
                .flatMap(foo -> foo.getOrgan().stream()
                    .map(organ -> new AbstractMap.SimpleEntry<>(organ, foo)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        default:
            throw new AssertionError(criteria);
    }
    return fooList.stream().collect(Collectors.groupingBy(simpleKeyCriteria));
}