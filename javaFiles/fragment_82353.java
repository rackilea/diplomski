static Map<String, String> flatten(Map<String, Object> map, String p) {
    final String prefix = p.isEmpty() ? p : p + ".";
    return map.entrySet()
              .stream()
              .map(e -> {
                  if (e.getValue() instanceof Map) {
                      return (Set<Map.Entry<String, String>>) flatten((Map) e.getValue(), prefix + e.getKey()).entrySet();
                  } else {
                      return Map.of(prefix + e.getKey(), e.getValue().toString()).entrySet();
                  }
              })
              .flatMap(Set::stream)
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}