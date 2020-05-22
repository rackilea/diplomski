class TestIterable<T extends Test> implements Iterable<T> {

    final List<T> result = new ArrayList<>();

    public TestIterable(T obj) {
        result.add(obj);
    }

    public TestIterable(Class<T> type, Object obj) {
        if (obj == null || type.isAssignableFrom(obj.getClass())) {
            result.add(type.cast(obj));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return result.iterator();
    }
}