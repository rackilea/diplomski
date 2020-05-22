public void permutation(double[] arr, int pos, Consumer<double[]> consumer) {
    if (arr.length - pos == 1)
        consumer.accept(arr);
    else
        for (int i = pos; i < arr.length; i++) {
            swap(arr, pos, i);
            permutation(arr, pos + 1, list);
            swap(arr, pos, i);
        }
}