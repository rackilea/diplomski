public static int recursiveCount(int[] array, int value) {
    return recursiveCountInternal(array, value, 0, 0);
}

private static int recursiveCountInternal(int[] array, int value, int index, int count) {
    if (index == array.length) {
        return count;
    }
    if (array[index] == value) {
        count++;
    }
    return recursiveCountInternal(array, value, index + 1, count);
}