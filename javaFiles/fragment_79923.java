public static int binarySearch(int[] a, int start, int end, int x) {
    if (start > end) {
        return -1;
    }
    int mid = (start + end) / 2;
    if (a[mid] == x) {
        return mid;
    } else if (a[mid] > x) {
        return binarySearch(a, start, mid - 1, x); // return here
    } else {
        return binarySearch(a, mid + 1, end, x);   // return here
    }

}