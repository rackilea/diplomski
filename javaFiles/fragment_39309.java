public int[] cube(final int[] array) {
    // Initialize a new array, with the same size as the input one,
    // to hold the computed value. We will return this array instead
    // of modifying the inputted one. 
    final int[] powResult = new int[array.length];

    for (int i = 0; i < array.length; i++) {
        powResult[i] = (int) Math.pow(array[i], 3);
    }

    return powResult;
}