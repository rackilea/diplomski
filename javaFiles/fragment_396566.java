public static void main(String args[]) {
    System.out.println(binarySearch(new int[] {-100, -50, -30, 3, 500, 800}));
    System.out.println(binarySearch(new int[] {-100, -50, -30, 42, 500, 800}));
    System.out.println(binarySearch(new int[] {-8, 1, 2, 3, 4, 100, 200, 300, 500, 700, 9000}));
}

// Searches for a solution to x[i]=i, returning -1 if no solutions exist.
// The algorithm only works if the array is in ascending order and has no repeats.
// If there is more than one solution there is no guarantee which will
// be returned. Worst case time complexity O(log n) where n is length of array.
public static int binarySearch(int[] x) {
    if (x == null || x.length == 0)
        return -1;
    int low = 0;
    if (x[low] == low)
        return 0;
    else if (x[low] > low)
        return -1;
    int high = x.length - 1;
    if (x[high] == high)
        return high;
    else if (x[high] < high)
        return -1;
    while (high - low >= 2) {
        int mid = (high + low) / 2;
        if (x[mid] == mid)
            return mid;
        else if (x[mid] > mid)
            high = mid;
        else low = mid;
    }
    return -1;
}