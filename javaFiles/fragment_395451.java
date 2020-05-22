public static <K> void mergeSort(K[] arr, Comparator<? super K> comp) {
    int n = arr.length, mid = n / 2;
    if (n < 2) {
        return;
    }
    K[] left = Arrays.copyOfRange(arr, 0, mid), right = Arrays.copyOfRange(arr, mid, n);
    mergeSort(left, comp);
    mergeSort(right, comp);
    merge(left, right, arr, comp);
}