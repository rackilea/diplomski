@Override
public Iterator<T> iterator() {
    Iterator<T> delegate = super.iterator();
    return new Iterator<T>() {
        @Override
        public boolean hasNext() {
            return delegate.hasNext();
        }

        @Override
        public T next() {
            return delegate.next();
        }

    };
}