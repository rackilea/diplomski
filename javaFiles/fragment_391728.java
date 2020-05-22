public abstract class LinkedStack<T> implements Iterable<T>{
    private Node<T> first = null;

    private class Node<U>{
        private U       item;
        private Node<U>    next;
    }

    private class LinkedStackIterator implements Iterator<T>{
        private Node<T> current = first; //Error here

        public boolean hasNext() { return current.next == null; }
        public void     remove() { throw new UnsupportedOperationException(); }
        public T        next()
        {
            T item      = current.item;
            current     = current.next;
            return item;
        }
    }
}