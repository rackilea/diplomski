public static <U extends Comparable<U>> Object[] sortedCopy(Comparator<? super U> comparator, U... values) {
    U[] copy = Arrays.copyOf(values, values.length);
    Arrays.sort(copy, comparator);
    return copy;
}

public static <U extends Comparable<U>> Object[] sortedCopy(U... values) {
    return sortedCopy(Comparator.naturalOrder(), values);
}