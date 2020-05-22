Object findHighest(Comparator comparator, Collection collection) {
    Object highest = null;
    for (Object element : collection) {
        if (highest == null || comparator.compare(element, highest) > 0)
            highest = element;
    }

    return highest;
}