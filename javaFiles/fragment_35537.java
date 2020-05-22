final class MapSplitters {

    private MapSplitters() {
    }

    static <K, V> Splitter<Map.Entry<K, V>, Map<K, V>, K, V> of(final Function<? super K, ? extends K[]> keyToKeyGroup) {
        return of(keyToKeyGroup, LinkedTreeMap::new);
    }

    static <K, V> Splitter<Map.Entry<K, V>, Map<K, V>, K, V> of(final Function<? super K, ? extends K[]> keyToKeyGroup,
            final Supplier<? extends Map<K, V>> mapFactory) {
        return Splitter.of(
                Map.Entry::getKey,
                Map.Entry::getValue,
                keyToKeyGroup, mapFactory, (innerMap, key) -> {
                    @SuppressWarnings("unchecked")
                    final Map<K, V> castInnerMap = (Map<K, V>) innerMap.get(key);
                    return castInnerMap;
                },
                Map::put
        );
    }

}