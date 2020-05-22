public static <T,K,V> Collector<T,?,Map<K,V>> toMapWithLimit(
    Function<? super T, ? extends K> key, Function<? super T, ? extends V> value,
    int limit, K fallBack, BinaryOperator<V> merger) {

    return Collector.of(LinkedHashMap::new, (map, t) ->
            mergeWithLimit(map, key.apply(t), value.apply(t), limit, fallBack, merger),
            (map1,map2) -> {
                if(map1.isEmpty()) return map2;
                if(map1.size()+map2.size() < limit)
                    map2.forEach((k,v) -> map1.merge(k, v, merger));
                else
                    map2.forEach((k,v) ->
                        mergeWithLimit(map1, k, v, limit, fallBack, merger));
                return map1;
            });
}
private static <T,K,V> void mergeWithLimit(Map<K,V> map, K key, V value,
    int limit, K fallBack, BinaryOperator<V> merger) {
    map.merge(map.size() >= limit && !map.containsKey(key)? fallBack: key, value, merger);
}