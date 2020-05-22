public class Pair<E, F> {
    private final E e;
    private final F f;
    public Pair(E e, F f) {
        this.e = e;
        this.f = f;
    }

    public E getE() {
        return e;
    }
    public F getF() {
        return f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<E,F> other = (Pair<E,F>) obj;
        if (!this.e.equals(other.getE())) {
           return false;
        }
        if (!this.f.equals(other.getF())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        hash = 53 * e.hashCode() + f.hashCode();
        return hash;
    }
}