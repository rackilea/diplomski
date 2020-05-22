public static <N extends Comparable<N>> N getSmallestValue(List<N> a) {
    Collections.sort(a);
    return a.get(0);
}

public static <N extends Comparable<N>> N getSmallestValue2(List<N> a) {
    return Collections.min(a);
}

List<Integer> ints = Arrays.asList(-1, 56, -100);
int min = getSmallestValue(ints);
// or
int min = Collections.min(ints);