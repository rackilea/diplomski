static int countClamps(int[] arr) {
    int result = 0;
    for (int i = 1; i < arr.length; ++i) {
        if (arr[i] == arr[i-1]
                && (i == arr.length-1 || arr[i] != arr[i+1])) {
            ++result;
        }
    }
    return result;
}