public static void insertionSort(int[] array) {
    if (array.length <= 1) {
        return;
    }

    // Start with an initially sorted part.
    int loSorted = array.length - 1;
    //int hiSorted = array.length;

    while (loSorted > 0) {

        // Take one from the array
        int x = array[0];

        // Where in the sorted part to insert?
        int insertI = insertPosition(array, loSorted);

        // Insert x at insertI
        ...
        --loSorted;
    }
}