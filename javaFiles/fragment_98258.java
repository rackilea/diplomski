private static String findCycles(int[] a, int[] b) {
    if (a.length == 0)
        throw new IllegalArgumentException("The sets cannot be empty");
    if (a.length != b.length)
        throw new IllegalArgumentException("Sets must have same size: " + a.length + " != " + b.length);
    TreeMap<Integer, Integer> numIdx = IntStream.range(0, a.length).boxed()
            .collect(Collectors.toMap(i -> a[i], Function.identity(),
                                      (i1, i2) -> { throw new IllegalArgumentException("Duplicate numbers not allowed: " + a[i1]); },
                                      TreeMap::new));
    if (! IntStream.of(b).boxed().collect(Collectors.toSet()).equals(numIdx.keySet()))
        throw new IllegalArgumentException("Sets must consist of the same numbers");
    String separator = (numIdx.firstKey() < 0 || numIdx.lastKey() > 9 ? " " : "");
    BitSet used = new BitSet(a.length);
    StringBuilder result = new StringBuilder();
    for (int idx; (idx = used.nextClearBit(0)) < a.length; ) {
        StringJoiner cycle = new StringJoiner(separator, "(", ")");
        do {
            used.set(idx);
            cycle.add(String.valueOf(a[idx]));
            idx = numIdx.get(b[idx]);
        } while (! used.get(idx));
        result.append(cycle.toString());
    }
    return result.toString();
}