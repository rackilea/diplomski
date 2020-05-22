public static int[] replicate(int[] array, int n) {
    int[] newArray = new int[array.length - array.length / n];
    int j = 0;
    for (int i = 0; i != array.length; i++) {
        if ((i + 1) % n != 0) {
            newArray[j++] = array[i];
        }
    }
    return newArray;
}