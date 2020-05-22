public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
    int minIndex = index;
    for (int i = index; i < array.length; i++) {
        if (array[i] < array[minIndex]) {
            minIndex = i;
        }
    }
    return minIndex;
}