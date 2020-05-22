public static int findIndex(Object[] arr, Object o) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        if (o.equals(arr[i])) {
            return i;
        }
    }
    return -1;
}