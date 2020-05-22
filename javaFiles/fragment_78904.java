public static <T extends Comparable<T>> T maxA(final T[] data,int from, int to) {
    return Collections.max(Arrays.asList(Arrays.copyOfRange(data, from, to)));
}
public static <T extends Comparable<T>> T maxB(final T[] data,int from, int to) {
    return Collections.max(Arrays.asList(data).subList(from, to));
}