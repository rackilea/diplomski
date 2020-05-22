private static <T> Map<T, Integer> createIdMap(Stream<T> values) {
    return values.collect(HashMap::new, (m,t) -> m.putIfAbsent(t,m.size()),
        (m1,m2) -> {
            if(m1.isEmpty()) m1.putAll(m2);
            else m2.keySet().forEach(t -> m1.putIfAbsent(t, m1.size()));
        });
}