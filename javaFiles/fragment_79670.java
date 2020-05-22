private static int highestSum(int[] array1, int[] array2) {
    if (array1.length != array2.length)
        throw new IllegalArgumentException();
    Arrays.sort(array1);
    Arrays.sort(array2);
    int sum = 0;
    for (int i = 0; i < array1.length; i++) {
        int value1 = array1[i];
        int value2 = array2[array2.length - i - 1];
        int max = Math.max(value1, value2);
        sum += max;
    }
    return sum;
}