public static <T> Collector<T,?,List<T>> cumulative(BinaryOperator<T> update) {
    return Collector.of(ArrayList::new,
        (l,o) -> {
            if(!l.isEmpty()) o=update.apply(l.get(l.size()-1), o);
            l.add(o);
        },
        (l,m) -> {
            if(l.isEmpty()) return m;
            if(!m.isEmpty()) {
                T a = l.get(l.size()-1);
                for(T b: m) l.add(update.apply(a, b));
            }
            return l;
        });
}