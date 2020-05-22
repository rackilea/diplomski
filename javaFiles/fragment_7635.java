LinkedHashSet<LinkedHashSet<String>> result = Stream.of(map1, map2, map3)
    .flatMap( map -> map.entrySet().stream() )
    .collect( Collectors.collectingAndThen(
        Collectors.groupingBy(Map.Entry::getKey,
            LinkedHashMap::new,
            Collectors.mapping(Map.Entry::getValue,
                Collectors.toCollection(LinkedHashSet::new))),
        m -> new LinkedHashSet<>(m.values())));