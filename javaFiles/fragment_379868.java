private static void merge(int[] arr) {
    for (int i = 0; i + 1 < arr.length; i += 2) {
        if (arr[i] == arr[i + 1]) {
            arr[i] *= 2;
            arr[i + 1] = 0;
        }
    }
}