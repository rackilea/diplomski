static int[] addAtIndex(
        final int[] array,
        final int value,
        final int index) {
    if (array == null || array.length == 0) {
        // We cannot do anything.
        // Simply return to the caller
        return array;
    }

    // This is the array reference holder
    int[] localArray = array;

    // Get the last element of the array
    final int last = localArray[localArray.length - 1];

    // Is the last element 0? Remember an int array cannot contain nulls
    if (last == 0) {
        if (array[index] != 0) {
            // We need to shift everything to the right
            // to give space to the new element
            shiftRight(localArray, index);
        }
    } else {
        // Create a bigger array of length = actualLength + 1
        // and assign it to the reference holder
        localArray = new int[array.length + 1];

        // Copy the array elements to the new array, leaving a space
        // for the new element
        copyArrayAndLeaveSpace(index, array, localArray);
    }

    // Assign the new value
    localArray[index] = value;

    // Return the modified array reference
    return localArray;
}

static void shiftRight(
        final int[] array,
        final int index) {
    System.arraycopy(array, index, array, index + 1, array.length - index - 1);
}

static void copyArrayAndLeaveSpace(
        final int index,
        final int[] array,
        final int[] newArray) {
    System.arraycopy(array, 0, newArray, 0, index);
    System.arraycopy(array, index, newArray, index + 1, array.length - index);
}