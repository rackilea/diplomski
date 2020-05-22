public static <T> Collector<Entry<T, T>, ?, List<List<T>>> chaining() {
    BiConsumer<Map<T, ArrayDeque<T>>, Entry<T, T>> accumulator = (
            m, entry) -> {
        ArrayDeque<T> k = m.remove(entry.getKey());
        ArrayDeque<T> v = m.remove(entry.getValue());
        if (k == null && v == null) {
            // new pair does not connect to existing chains
            // create a new chain with two elements
            k = new ArrayDeque<>();
            k.addLast(entry.getKey());
            k.addLast(entry.getValue());
            m.put(entry.getKey(), k);
            m.put(entry.getValue(), k);
        } else if (k == null) {
            // new pair prepends an existing chain
            v.addFirst(entry.getKey());
            m.put(entry.getKey(), v);
        } else if (v == null) {
            // new pair appends an existing chain
            k.addLast(entry.getValue());
            m.put(entry.getValue(), k);
        } else {
            // new pair connects two existing chains together
            // reuse the first chain and update the tail marker
            // btw if k == v here, then we found a cycle
            k.addAll(v);
            m.put(k.getLast(), k);
        }
    };
    BinaryOperator<Map<T, ArrayDeque<T>>> combiner = (m1, m2) -> {
        throw new UnsupportedOperationException();
    };
    // our map contains every chain twice: mapped to head and to tail
    // so in finisher we have to leave only half of them 
    // (for example ones connected to the head).
    // The map step can be simplified to Entry::getValue if you fine with
    // List<Collection<T>> result.
    Function<Map<T, ArrayDeque<T>>, List<List<T>>> finisher = m -> m
            .entrySet().stream()
            .filter(e -> e.getValue().getFirst().equals(e.getKey()))
            .map(e -> new ArrayList<>(e.getValue()))
            .collect(Collectors.toList());
    return Collector.of(HashMap::new, accumulator, combiner, finisher);
}