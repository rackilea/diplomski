public static int[] countNumbers(int[] numbers) {
    int[] counts = new int[10];

    for (int i = 0; i < counts.length; i++)
        counts[numbers[i] - 1]++;

    return counts;
}