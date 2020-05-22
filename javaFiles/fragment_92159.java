static <T extends Comparable<T>> Comparator<HasValue<T>> createValueComparator() {
    return new Comparator<HasValue<T>>() {
        @Override
        public int compare(HasValue<T> o1, HasValue<T> o2) {
            return o1.value().compareTo(o2.value());
        }
    };
}