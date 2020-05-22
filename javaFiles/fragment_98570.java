static <T> Comparator<T> comparingByIndex(List<? extends T> ordering,
                                          Comparator<? super T> cmp) {
    return (t1, t2) -> {
        int c1 = ordering.indexOf(t1);
        int c2 = ordering.indexOf(t2);
        if (c1 == -1 && c2 == -1) {
            return cmp.compare(t1, t2);
        } else {
            return Integer.compareUnsigned(c1, c2);
        }
    };
}