private static <T> Map<T, Integer> createIdMap(Stream<T> values) {
    return values.distinct().collect(HashMap::new, (m,t) -> m.put(t,m.size()),
        (m1,m2) -> { int leftSize=m1.size();
            if(leftSize==0) m1.putAll(m2);
            else m2.forEach((t,id) -> m1.put(t, leftSize+id));
        });

}