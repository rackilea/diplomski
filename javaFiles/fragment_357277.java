public static Map<String, Map<String, String>> convertRawMapToStringValues(
       Map<String, Map<String, Object>> in) {

    return in.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
            e -> e.getValue().entrySet().stream()
            .collect(
                HashMap::new,
                (m,e2) -> m.put(e2.getKey(),
                    e2.getValue() == null? null: e2.getValue().toString()),
                Map::putAll)));
}