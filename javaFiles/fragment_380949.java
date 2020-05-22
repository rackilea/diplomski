private static <T> List<List<T>> unmodifiableList2(final List<List<T>> input) {
    return Collections.unmodifiableList(new ForwardingList<List<T>>() {
        @Override protected List<List<T>> delegate() {
            return Collections.unmodifiableList(input);
        }
        @Override public List<T> get(int index) {
            return Collections.unmodifiableList(delegate().get(index));
        }
    });
}