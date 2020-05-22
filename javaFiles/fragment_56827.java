private void compute(String key, String[] parts) {
  myMap.merge(key, 
    s -> Stream.of(parts)
               .limit(parts.length - 1)
               .collect(toSet()),
               (currentSet, newSet) -> {currentSet.addAll(newSet); return currentSet;});
}