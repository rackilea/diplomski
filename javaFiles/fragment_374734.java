private static void parseResponse(Map<String, Map<String, Object>> response, List<Map<String, Object>> s) {
    s.stream()
     .filter(maps -> maps != null && maps.containsKey("productId"))
     .forEach(maps ->
        response.merge(maps.get("productId").toString(),
                       new HashMap<>(maps),
                       (m1, m2) -> {
                           Map<String, Object> merged = new HashMap<>(m1);
                           merged.putAll(m2);
                           return merged;
                       }));
}