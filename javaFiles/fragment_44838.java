public static <T> List<T> sizedSubList(List<T> list, long maxSize) {
    long totalSize = 0;
    int i = list.size() - 1;
    while (i >= 0) {
        totalSize += SizeOf.deepSizeOf(list.get(i));
        if (totalSize > maxSize) break;
        i--;
    }

    return list.subList(i + 1, list.size());
}