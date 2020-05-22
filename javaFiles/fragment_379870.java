private static void moveToFront(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] != 0) {
                    swap(arr, i, j);
                }
            }
        }
    }
}