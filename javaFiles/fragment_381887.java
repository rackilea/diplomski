public static <T extends Comparable<? super T>> List<T> merge(Set<List<T>> lists) {
    int totalSize = 0; // every element in the set
    for (List<T> l : lists) {
        totalSize += l.size();
    }

    List<T> result = new ArrayList<T>(totalSize);

    List<T> lowest;

    while (result.size() < totalSize) { // while we still have something to add
        lowest = null;

        for (List<T> l : lists) {
            if (! l.isEmpty()) {
                if (lowest == null) {
                    lowest = l;
                } else if (l.get(0).compareTo(lowest.get(0)) <= 0) {
                    lowest = l;
                }
            }
        }

        result.add(lowest.get(0));
        lowest.remove(0);
    }

    return result;
}