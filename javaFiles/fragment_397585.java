public static <T> Collector<T,?,Map<Integer,List<T>>>
                  grouping(ToIntFunction<T> f, int limit) {
    return Collector.of(HashMap::new,
        (m,t) -> {
            int v = f.applyAsInt(t);
            if(v < limit) m.computeIfAbsent(v, x -> new ArrayList<>()).add(t);
        },
        (m1,m2) -> {
            m2.forEach((k,v) -> m1.merge(k, v, (l1,l2)->{ l1.addAll(l2); return l1; }));
            return m1;
        });
}