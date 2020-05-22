/**
 * Returns the least index in this array with value strictly equal to the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryFirst(int[] a, int key) {
    int idx = binaryCeiling(a, key);
    return (idx < 0 || a[idx] != key ? -1 : idx);
}

/**
 * Returns the greatest index in this array with value strictly equal to the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryLast(int[] a, int key) {
    int idx = binaryFloor(a, key);
    return (idx < 0 || a[idx] != key ? -1 : idx);
}

/**
 * Returns the greatest index in this array with value strictly less than the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryLower(int[] a, int key) {
    return binarySearch(a, x -> Integer.compare(x, key) < 0);
}

/**
 * Returns the greatest index in this array with value less than or equal to the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryFloor(int[] a, int key) {
    return binarySearch(a, x -> Integer.compare(x, key) <= 0);
}

/**
 * Returns the least index in this array with value greater than or equal to the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryCeiling(int[] a, int key) {
    int idx = binaryLower(a, key) + 1;
    return (idx == a.length ? -1 : idx);
}

/**
 * Returns the least index in this array with value strictly greater than the given key,
 * or {@code -1} if there is no such key.
 */
public static int binaryHigher(int[] a, int key) {
    int idx = binaryFloor(a, key) + 1;
    return (idx == a.length ? -1 : idx);
}

private static int minComp = Integer.MAX_VALUE; // For stats
private static int maxComp = Integer.MIN_VALUE; // For stats
private static int countComp = 0;               // For stats
private static int countSearch = 0;             // For stats

private static int binarySearch(int[] a, IntPredicate searchRight) {
    if (a.length == 0)
        return -1;
    int comp = 0; // For stats
    int first = 0, last = a.length - 1;
    while (first + 1 < last) {
        int mid = (first + last) / 2;
        comp++; // For stats
        if (searchRight.test(a[mid]))
            first = mid;
        else
            last = mid;
    }
    int result;
    if (first == last || first == 0) {
        comp++; // For stats
        result = (searchRight.test(a[first]) ? first : first - 1);
    } else if (last == a.length - 1) {
        comp++; // For stats
        result = (searchRight.test(a[last]) ? last : last - 1);
    } else {
        result = first;
    }
    minComp = Math.min(minComp, comp); // For stats
    maxComp = Math.max(maxComp, comp); // For stats
    countComp += comp;                 // For stats
    countSearch++;                     // For stats
    return result;
}