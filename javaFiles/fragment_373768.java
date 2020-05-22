public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};
    int[][] splits = splitArray(2, numbers);
    System.out.println("Split arrays: " + Arrays.deepToString(splits));
}

private static int[][] splitArray(int splitCount, int[] numbers) {
    if (numbers.length == 0) {
        return new int[0][0];
    }

    int splitLength = (int) Math.ceil((double) numbers.length / (double) splitCount);
    int[][] splits = new int[splitCount][];

    int j = 0;
    int k = 0;
    for (int i = 0; i < numbers.length; i++) {
        if (k == splitLength) {
            k = 0;
            j++;
        }
        if (splits[j] == null) {
            int remainingNumbers = numbers.length - i;
            splits[j] = new int[Math.min(remainingNumbers, splitLength)];
        }
        splits[j][k++] = numbers[i];
    }
    return splits;
}