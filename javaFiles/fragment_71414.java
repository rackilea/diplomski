public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> comparator) {
    int low = 0;
    int high = list.size() - 1;
    int index = 0;

    while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = comparator.compare(key, list.get(mid));
        if (cmp == 0) {
            index = mid;
            return index;
        } else if (cmp < 0) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return index;
}