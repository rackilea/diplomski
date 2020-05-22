public static void insertion_srt(int array[], int beg_index, int n) {
    if(beg_index >= n-1)
            return;
    int i = beg_index + 1;
    int j = i;
    int B = array[i];
    j=helper(array, j, B);
    array[j] = B;
    insertion_srt(array, beg_index + 1, n);
}

private static int helper(int[] array, int j, int B) {
    if(j <= 0 || array[j-1] <= B)
        return j;
    array[j] = array[j - 1];
    return helper(array, j-1, B);
}