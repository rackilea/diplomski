public static int oldStyleSum(final int[] numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.length; ++i) {
        sum += numbers[i];
    }
    return sum;
}