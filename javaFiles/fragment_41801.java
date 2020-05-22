Map<String, Set<String>> collect = map.entrySet()
    .parallelStream()
    // Expand (k, {v1, v2, v3}) to [(v1, k), (v2, k), (v3, k)]
    .flatMap(e -> e.getValue().stream().map(ee -> new SimpleEntry<>(ee, e.getKey())))
    .collect(
        Collectors.groupingBy(
            Map.Entry::getKey,
            Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));