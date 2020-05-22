class MyClass implements List<String> {
    private ArrayList<String> inner = new ArrayList<>();

    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public boolean isEmpty() {
        return inner.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return inner.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return inner.iterator();
    }

    @Override
    public Object[] toArray() {
        return inner.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return inner.toArray(a);
    }

    @Override
    public boolean add(String s) {
        return inner.add(s);
    }

    @Override
    public boolean remove(Object o) {
        return inner.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return inner.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return inner.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return inner.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return inner.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return inner.retainAll(c);
    }

    @Override
    public void clear() {
        inner.clear();
    }

    @Override
    public String get(int index) {
        return inner.get(index);
    }

    @Override
    public String set(int index, String element) {
        return inner.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        inner.add(index, element);
    }

    @Override
    public String remove(int index) {
        return inner.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return inner.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return inner.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return inner.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return inner.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return inner.subList(fromIndex, toIndex);
    }
}