public static <T,A,R> Collector<T,A,R> characteristics(
                      Collector<T,A,R> c, Collector.Characteristics... ch) {
    Set<Collector.Characteristics> o = c.characteristics();
    if(!o.isEmpty()) {
        o=EnumSet.copyOf(o);
        Collections.addAll(o, ch);
        ch=o.toArray(ch);
    }
    return Collector.of(c.supplier(), c.accumulator(), c.combiner(), c.finisher(), ch);
}