public class X<E> {
    private final Iterator<E> it;

    public X(Iterable<E> a) {
        it = a.iterator();
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    public E next() {
        return it.next();
    }
}