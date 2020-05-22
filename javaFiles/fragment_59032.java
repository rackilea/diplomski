private class SequenceSelector implements Selector {
    private final Iterator<T> iterator = items.iterator();

    private T obj = iterator.next();
    public boolean end() { return !iterator.hasNext(); }
    public T current() { return obj; }
    public void next() { obj = iterator.next(); }
}