<T> T findHighest(Comparator<T> comparator, Collection<? extends T> collection) {
    T highest = null;
    for (T element : collection) {
        if (highest == null || comparator.compare(element, highest) > 0)
            highest = element;
    }

    return highest;
}