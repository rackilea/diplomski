Map<String, Multimap<String, Object>> merged = new HashMap<>();
BiFunction<Multimap<String, Object>, Multimap<String, Object>, Multimap<String, Object>> remappingFunction = (value1, value2) -> {
    Multimap<String, Object> multimap = HashMultimap.<String, Object>create();
    multimap.putAll(value1);
    multimap.putAll(value2);
    return multimap;
};
map1.forEach((key, value) -> merged.merge(key, Multimaps.forMap(value), remappingFunction));
map2.forEach((key, value) -> merged.merge(key, Multimaps.forMap(value), remappingFunction));
merged.get("config").get("key1");