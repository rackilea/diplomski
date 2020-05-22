public static void reverse(int[] array) {
    if (array == null) {
        return;
    }
    int i = 0;
    int j = array.length - 1;
    int tmp;
    while (j > i) {
        tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
        j--;
        i++;
    }
}