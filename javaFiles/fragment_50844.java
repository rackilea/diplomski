public static int[] getRanksArray(int[] array) {
    int[] result = new int[array.length];

    for (int i = 0; i < array.length; i++) {
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > array[i]) {
                count++;
            }
        }
        result[i] = count + 1;
    }
    return result;
}