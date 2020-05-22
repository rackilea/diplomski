public Iterator<E> iterator() {
    return new FifoIterator();
}

private final class FifoIterator implements Iterator<E> {
    private QueueNode<E> curr;
    FifoIterator() {
        this.curr = FifoQueue.this.last;
    }
    @Override
    public boolean hasNext() {
        return (this.curr != null);
    }
    @Override
    public E next() {
        if (this.curr == null)
            throw new NoSuchElementException();
        this.curr = this.curr.next;
        E e = this.curr.element;
        if (this.curr == FifoQueue.this.last)
            this.curr = null;
        return e;
    }
}