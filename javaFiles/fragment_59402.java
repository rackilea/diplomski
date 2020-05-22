Comparator<Integer> ascComparator = (o1, o2) -> {
    if (o1 == null && o2 == null) return 0;
    else if (o1 == null && o2 != null) return -1;
    else if (o1 != null && o2 == null) return 1;
    else return Integer.compare(o1, o2);
};