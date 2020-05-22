/**
 * @param array sorted
 * @param keys sorted
 * @return found keys
 */
static Set<Integer> search(int[] array, int[] keys) {
    Set<Integer> foundKeys = new HashSet<>();
    find(foundKeys, array, 0, array.length, keys, 0, keys.length);
    return foundKeys
}

private static find(Set<Integer> foundKeys,
        int[] array, int a0, int an,
        int[] keys, int k0, int kn) {
    if (k0 < kn) {
        int k = (k0 + kn) / 2;
        int key = keys[k];
        int a = Arrays.binarySearch(array, a0, an, key);
        if (a >= 0) {
            foundKeys.add(key);
        } else {
            a = ~a;
        }
        find(foundKeys, array, a0, a, keys, k0, k);
        find(foundKeys, array, a, an, keys, k + 1, kn);
        // The overlap at a / repetition of a is due to:
        // - not found
        // - found but keys theoretically might contain doubles
    }
}