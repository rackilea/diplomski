public static int[] intersperseC(int[] array1, int[] array2) {
    int[] resultArray = new int[array1.length + array2.length];
    int cursor = 0;
    for (int i = 0; i < Math.max(array1.length, array2.length); i++) {
        if (i < array1.length) {
            resultArray[cursor++] = array1[i];
        }
        if (i < array2.length) {
            resultArray[cursor++] = array2[i];
        }
    }
    return resultArray;
}