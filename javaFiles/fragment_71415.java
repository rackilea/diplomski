public static <T> int binarySearchByStringField(List<? extends T> list, String key, Function<T, String> keyExtractor) {
    int low = 0;
    int high = list.size() - 1;
    int index = 0;

    while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = key.compareTo(keyExtractor.apply(list.get(mid)));
        if (cmp == 0) {
            index = mid;
            return index;
        } else if (cmp < 0) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return -1 - low;
}