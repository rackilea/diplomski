private static void incrementArrayDigits(int[] array, int position) {
    if (position >= array.length || position < 0) {
        return;
    }
    array[position]++;
    if (array[position] == 10 && position != 0) {
        array[position] = 0;
        incrementArrayDigits(array, position - 1);
    }
}

// usage:

int[] array = {9,9,9};
incrementArrayDigits(array, array.length - 1);
System.out.println(Arrays.toString(array));