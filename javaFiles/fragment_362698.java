int sequenceMin(int[] set) {
    int[] arr = Arrays.copy(set);
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 3 + 1; ++i) {
        if (arr[i] == arr[i + 2] - 2) {
            return arr[i];
        }
    }
    return -1;
}