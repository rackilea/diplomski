public static int[] revv(int[] arr) {
    int[] arr2 = new int[arr.length];

    for (int i = 0 ; i < arr.length ; i++) {
        arr2[i] = arr[arr.length - i - 1];
    }

    return arr2;
}