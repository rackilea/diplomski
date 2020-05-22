public static <E> Comparator<E> parseSortBy(String sortBy, Function<String, Comparator<E>> fieldComparatorMapper) {
    Comparator<E> sortComparator = null;
    for (String field : sortBy.split(";")) {
        boolean descending = field.endsWith("-");
        Comparator<E> c = fieldComparatorMapper.apply(descending ? field.substring(0, field.length() - 1) : field);
        if (descending)
            c = c.reversed();
        sortComparator = (sortComparator == null ? c : sortComparator.thenComparing(c));
    }
    return sortComparator;
}