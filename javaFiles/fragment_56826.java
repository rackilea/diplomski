private void compute(String key, String[] parts) {
  myMap.computeIfAbsent(key, 
    s -> Stream.of(parts)
               .limit(parts.length - 1)
               .collect(toSet()));
}