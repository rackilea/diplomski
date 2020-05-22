Map<String, Set<String>> collect = new HashSet<>();
for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
  for (String v : entry.values()) {
      collect.computeIfAbsent(v -> new HashSet<>())
              .add(entry.getKey()));
  }
}