// from http://langexplr.blogspot.com.au/2007/12/combining-iterators-in-java.html

import java.util.Iterator;

public class FlattenIterable<T> implements Iterable<T> {
    private Iterable<Iterable<T>> iterable;

    public FlattenIterable(Iterable<Iterable<T>> iterable) {
        this.iterable = iterable;
    }

    public Iterator<T> iterator() {
        return new FlattenIterator<T>(iterable.iterator());
    }

    static class FlattenIterator<T> implements Iterator<T> {
        private Iterator<Iterable<T>> iterator;
        private Iterator<T> currentIterator;

        public FlattenIterator(Iterator<Iterable<T>> iterator) {
            this.iterator = iterator;
            currentIterator = null;
        }

        public boolean hasNext() {
            boolean hasNext = true;
            if (currentIterator == null) {
                if (iterator.hasNext()) {
                    currentIterator = iterator.next().iterator();
                } else {
                    return false;
                }
            }

            while (!currentIterator.hasNext() && iterator.hasNext()) {
                currentIterator = iterator.next().iterator();
            }

            return currentIterator.hasNext();
        }

        public T next() {
            return currentIterator.next();
        }

        public void remove() {
        }
    }
}