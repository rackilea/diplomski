import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class cocI<T> implements Iterator<T> {

    private Iterator<Collection<T>> outerIterator;
    private Iterator<T> innerIterator;

    public cocI(Collection<Collection<T>> collofColl) {
        this.outerIterator = collofColl.iterator();
        advanceCollection();
    }

    @Override
    public boolean hasNext() {
        return this.innerIterator != null && this.innerIterator.hasNext();
    }

    @Override
    public T next() {
        if (this.innerIterator == null) {
            throw new NoSuchElementException();
        }
        try {
            return this.innerIterator.next();
        } finally {
            advanceCollection();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void advanceCollection() {
        while ((this.innerIterator == null || !this.innerIterator.hasNext())
               && this.outerIterator.hasNext()) {
            this.innerIterator = this.outerIterator.next().iterator();
        }
    }

}