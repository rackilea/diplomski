public static void quicksort(int[] array, int begin, int end) {
    if (array == null || array.length() == 0) {
        return;
    }
    int pivot = partition(array);
    quicksort(array, 0, pivot);
    quicksort(array, pivot + 1, array.length);
}

public static void quicksort(int[] array) {
    quicksort(array, 0, array.length());
}