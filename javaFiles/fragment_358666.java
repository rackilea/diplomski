public static int[] copyPositiveVals(int[] arr) {
    int count = 0;
    for(int x : arr) {
        if (x > 0) count++;
    }

    int[] arr2 = new int[count];
    int i = 0;
    for(int x : arr) {
        if (x > 0) {
             arr2[i] = x;
             i++;
        }
    }
    return arr2;
}