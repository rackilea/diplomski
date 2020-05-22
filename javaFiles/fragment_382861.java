interface Traversable<E> {
    boolean hasNext();
    E next();
}

interface Iterator<E> extends Traversable<E> {
    void remove();
}

final class Scanner implements Traversable<String> {

}