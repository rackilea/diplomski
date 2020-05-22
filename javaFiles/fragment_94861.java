public static Map<String, List<Foo>> mapByCriteria(List<Foo> fooList, Group criteria) {
    Stream<Foo> stream = fooList.stream(); // imagine more chained common operations
    Function<Foo, String> simpleKeyCriteria = null;
    Collector<Foo, ?, Map<String, List<Foo>>> collector = null;
    switch(criteria) {
        case CASSETTE: simpleKeyCriteria = Foo::getCassette; break;
        case DATE: simpleKeyCriteria = p -> p.getDate().toString(); break;
        case ORGAN: collector = Collectors.flatMapping(
            foo -> foo.getOrgan().stream()
                .map(organ -> new AbstractMap.SimpleEntry<>(organ, foo)),
            Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        default:
            throw new AssertionError(criteria);
    }
    if(collector == null) collector = Collectors.groupingBy(simpleKeyCriteria);
    return stream.collect(collector);
}