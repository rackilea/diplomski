LinkedHashMap<String, Object> ordered = keysToOrderBy.stream()
    .filter(map::containsKey)
    .collect(Collectors.toMap(
                e -> e,
                map::get, 
                (v1, v2) -> v1, LinkedHashMap::new));