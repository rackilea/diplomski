private static int search(int[] seq, int key, int low, int high) {

    while (low <= high) {
        // this is as good as low+(high-low)/2. 
        int mid = (low + high) >>> 1; // this is (low+high)/2

        int midVal = seq[mid];

        if (midVal < key) {
            low = mid + 1;
        }
        else if (midVal > key) {
            high = mid - 1;
        }
        else {
            // why break when you can return?
            return mid; // key found
        }
    }
    // key not found. Return the 2's complement of the insert position:
    // that is -(insertPosition+1)
    return -(low + 1);
}