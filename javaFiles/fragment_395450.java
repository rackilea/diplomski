public static <K> void merge(K[] left, K[] right, K[] arr, Comparator<? super K> comp) {
    int i = 0, j = 0;
    while (i + j < arr.length) {
        if (j == right.length || (i<left.length && comp.compare(left[i], right[j])<0)) {
            arr[i + j] = left[i++];
        } else {
            arr[i + j] = right[j++];
        }
    }
}