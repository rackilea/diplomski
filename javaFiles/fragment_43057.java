public static int[][] partition(int[] set, int k) {
    if (set == null)
        return null; // Don't try to partition a null reference

    // If k = 0, the partition of the set is just the set
    if (k == 0) {
        int[][] partition = new int[1][set.length];
        // Copy the original set into the partition
        System.arraycopy(set, 0, partition[0], 0, set.length);
        return partition;
    }

    int numPartitions = 1 << k; // The number of sets to partition the array into
    int numElements = set.length / numPartitions; // The number of elements per partition

    /* Check if the set has enough elements to create a partition and make sure
       that the partitions are even */
    if (numElements == 0 || set.length % numElements != 0)
        return null; // Replace with an error/exception of your choice

    int[][] partition = new int[numPartitions][numElements];
    int index = 0;

    for (int r = 0; r < numPartitions; r++) {
        for (int c = 0; c < numElements; c++) {
            partition[r][c] = set[index++]; // Assign an element to the partition
        }
    }

    return partition;
}