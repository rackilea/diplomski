// The following method should be in a separate helper class for reusability
public static <E> Comparator<E> parseSortBy(String sortBy, Function<String, Comparator<E>> fieldComparatorMapper) {
    Comparator<E> sortComparator = null;
    for (String field : sortBy.split(";")) {
        Comparator<E> c = fieldComparatorMapper.apply(field);
        sortComparator = (sortComparator == null ? c : sortComparator.thenComparing(c));
    }
    return sortComparator;
}