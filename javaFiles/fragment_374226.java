static int[] sum(int[]... input) {
    int maxLen = 0;
    for (int[] arr : input)
        if (arr.length > maxLen)
            maxLen = arr.length;
    int[] sum = new int[maxLen];
    for (int[] arr : input)
        for (int i = 0; i < arr.length; i++)
            sum[i] += arr[i];
    return sum;
}