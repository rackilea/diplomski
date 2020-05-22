public <T> Comparator<T> getComparator()  throws ReflectiveOperationException {
    Class<? extends Comparator> implementation
        = Class.forName("some.ClassName").asSubclass(Comparator.class);
    @SuppressWarnings("unchecked")
    final Comparator<T> c = implementation.newInstance();
    return c;
}