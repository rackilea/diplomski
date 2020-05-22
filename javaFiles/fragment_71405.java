public static void add(Map<String, Set<String>> map, String key, String value) {
    map.compute(key, (id, values) -> {
        (values = Optional.ofNullable(values).orElseGet(LinkedHashSet::new)).add(value);
        return values;
    });
}