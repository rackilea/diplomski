public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue
    (Map<K, V> map) {

    return map.entrySet()
            .stream()
            .sorted(Map.Entry.<K, V> comparingByValue().reversed())
            // Type here -----^ reversed() here -------^
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ));
}