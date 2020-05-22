class IntegerList {
    private final List delegate = new ArrayList();

    public boolean add(Integer i) {
        return delegate.add(i);
    }

    public Integer get(int index) {
        return (Integer) delegate.get(i);
    }

    public Iterator iterator() {
        return delegate.iterator();
    }

    // etc
}