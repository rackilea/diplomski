public static <T, C extends Comparable<? super C>> void sortByValue(List<T> list, final boolean ascending, final Function<C, T> valueFunction) {
    Collections.sort(list, new Comparator<T>() {
        @Override public int compare(T o1, T o2) {
            final C v1 = valueFunction.apply(o1);
            final C v2 = valueFunction.apply(o2);
            return v1.compareTo(v2) * (ascending ? 1 : -1);
        }
    });
}