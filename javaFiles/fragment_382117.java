private <K, V, V1, V2> Map<K, V> merge(Map<K, V1> map1, Map<K, V2> map2, BiFunction<V1, V2, V> mergeFunction) {
    return map1.entrySet().stream()
                          .filter(e -> map2.containsKey(e.getKey()))
                          .collect(Collectors.toMap(
                              Entry::getKey, 
                              e -> mergeFunction.apply(e.getValue(), map2.get(e.getKey()))
                          ));
}