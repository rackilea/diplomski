Comparator<Integer> comparator = (o1, o2) -> {
    final boolean isDesc = tc.getSortType() == SortType.DESCENDING;
    if (o1 == null && o2 == null) return 0;
    else if (o1 == null && o2 != null) return isDesc ? -1 : 1;
    else if (o1 != null && o2 == null) return isDesc ? 1 : -1;
    else return Integer.compare(o1, o2);
};