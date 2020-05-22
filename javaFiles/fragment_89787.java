public static int[] findSum(int[] values, int sum) {
    Arrays.sort(values);  // O(N * log N)
    for(int i = 0; i < values.length() - 1; i ++) { // O(n)
        int remainder = sum - values[i];
        // O(log N) and assuming you can't use the same value twice.
        int pos2 = Arrays.binarySearch(value, i + 1, values.length, remainder); 
        if (pos2 >= 0)
            return new int[] { i, pos2 };
    }
    return null;
}