private static Map<String, Map<String, Object>> convertResponse(List<Map<String, Object>> response) {
    return response.stream()
            .filter(maps -> maps != null && maps.containsKey("productId"))
            .collect(Collectors.toMap(maps -> maps.get("productId").toString(),
                                      Function.identity(),
                                      (m1, m2) -> { m1.putAll(m2); return m1; }));
}