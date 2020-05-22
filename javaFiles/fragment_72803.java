public class WrappedIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public WrappedIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public void remove() {
        this.iterator.remove();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public T next() {
        T next = iterator.next();
        System.out.println(next);
        return next;
    }
}