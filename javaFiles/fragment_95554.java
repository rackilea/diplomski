public static <T> void merge(List<T> listA, List<T> listB, BiPredicate<T, T> areEqual, ToIntFunction<T> hashFunction) {

    class Wrapper {
        final T wrapped;
        Wrapper(T wrapped) {
            this.wrapped = wrapped;
        }
        @Override
        public boolean equals(Object obj) {
            return areEqual.test(wrapped, ((Wrapper) obj).wrapped);
        }
        @Override
        public int hashCode() {
            return hashFunction.applyAsInt(wrapped);
        }
    }

    Set<Wrapper> wrapSet = listA.stream().map(Wrapper::new).collect(Collectors.toSet());

    listA.addAll(listB.stream()
                      .filter(t -> !wrapSet.contains(new Wrapper(t)))
                      .collect(Collectors.toList())
    );
}