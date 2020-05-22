public void put(int N) {
    if (size < array[0].length)
        array[0][size] = N;
    else { // need to create a bigger array

        int[] temp = new int[2 * size]; // Temporary create a new array with double size

        // fill the empty array with array[0] existing elements
        for (int i = 0; i < size; i++) {
            temp[i] = array[0][i];
        }

        // Change the array[0] to point to the new array
        array[0] = temp;

        // Add the new element to the new array
        array[0][size] = N;
    }
    size = size + 1;
}