public int findMaxEvenSum(int[] array) {
    int total = 0;

    for (int i=0; i < array.length; ++i) {
        total += array[i];
    }

    if (total % 2 == 0) {
        return total;
    }

    // otherwise iterate over the array and remove the smallest odd
    // number from the sum
    int lastOdd = 0;

    for (int i=0; i < array.length; ++i) {
        if (array[i] % 2 == 1 && (lastOdd == 0 || array[i] < lastOdd)) {
            total += lastOdd;
            total -= array[i];
            lastOdd = array[i];
        }
    }

    return total;
}