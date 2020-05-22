private List<Integer> mergeList(List<Integer> list1, List<Integer> list2, final int newSize) {

    // Enforce null object pattern
    if (list1 == null) {
        list1 = Collections.emptyList();
    }
    if (list2 == null) {
        list2 = Collections.emptyList();
    }

    // If duplicates are not desirable, a TreeSet would perform automatic sorting.
    List<Integer> result = new ArrayList<Integer>(list1);
    result.addAll(list2);

    Comparator<Integer> reverseSortComparator = new Comparator<Integer>() {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            return o2.compareTo(o1);
        }
    };

    Collections.sort(result, reverseSortComparator);

    if (result.size() > newSize) {
        return result.subList(0, newSize);
    } else {
        return result;
    }
}