public static void main(String... args) {
    int[] array = {10,2,2,3,5,6,1,32,123,2,32,32,32,1,23,123};

    int highestIndex = getHighestIndex(array);
    int[] frequencies = createFrequencyArray(array);

    System.out.println("Highest = " + array[highestIndex]);
    System.out.println("Highest value frequency " + frequencies[highestIndex]);

    // Finally display result
    for (int i = 0; i < frequencies.length; i++) {
        System.out.println(array[i] + " frequency " + frequencies[i]);
    }

}

public static int getHighestIndex(final int[] array) {
    // Assume the highest value is at position 1
    int highestIndex = 0;

    // Ensure the array has values
    if (array.length > 0) {
        // No need to check 1 again, thus start from position 2 or array[1]
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[highestIndex]) {
                highestIndex = i;
            } 
        }
    } else {
        highestIndex = -1;
    }

    return highestIndex;
}

public static int[] createFrequencyArray(final int[] array) {
    int[] frequencies = new int[array.length];
    for (int i = 0; i < array.length; i++) {
        int counter = 0;
        for (int j = 0; j < frequencies.length; j++) {
            if (array[i] == array[j]) {
                counter++;
            }
        }
        frequencies[i] = counter;
    }

    return frequencies;
}