public static int search(boolean[] array) {

    int low = 0, mid;
    int high = array.length - 1;
    boolean booleanValue;

    while (low <= high) {
        mid = (low + high) >>> 1;
        booleanValue = array[mid];
        if (booleanValue) low = mid + 1;
        else if (low == mid) return mid;
        else high = mid;
    }
    return -low;
}