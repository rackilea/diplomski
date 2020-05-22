private static <T> Stream<ArrayElement<T>> createStream(int row, T[] arr) {
    OfInt columns = IntStream.range(0, arr.length).iterator();
    return Arrays.stream(arr).map(elem -> new ArrayElement<>(row, columns.nextInt(), elem));
} 

private static <V> void iterateAction(ArrayElement<V> elem) {
    System.out.println(elem);
}