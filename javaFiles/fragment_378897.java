private class SubList extends AbstractList<E> implements RandomAccess {
    ...
    public Iterator<E> iterator() {
        return listIterator();
    }
    ...
}