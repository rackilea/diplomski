private class MyLinkedListIterator implements Iterator<E> {
    private Elem<E> elem = head;

    @Override
    public boolean hasNext() {
        return elem.getNext() != null;
    }

    @Override
    public E next() {
        return elem.getNext().getE();
    }
}