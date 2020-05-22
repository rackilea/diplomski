public int size(int[] array) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            return i;
        }
    }
    return -1;
}