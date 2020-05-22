class SomeClass<T> {
    private List<T> elements;
    private List<Comparator<T>> comparators;

    private final Comparator<T> combined = new Comparator<T>() {
        @Override
        public int compare(T e1, T e2) {
            for(Comparator<T> c : comparators) {
                int result = c.compare(e1, e2);

                if(result != 0)
                    return result;
            }

            return 0;
        }
    };

    ...

    private List<T> sorted(List<T> toSort) {
        Collections.sort(toSort, combined);

        return toSort;
    }
}