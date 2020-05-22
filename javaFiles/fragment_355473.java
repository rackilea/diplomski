public class MementoListIterator<E> implements Iterator<E> {

    public static class Memento {

        private int savedIndex;

        private Memento(MementoListIterator<?> mementoListIterator) {
            this.savedIndex = mementoListIterator.index;
        }

    }

    private List<E> elements;

    private int index = 0;

    public MementoListIterator(List<E> elements) {
        this.elements = elements;
    }

    public Memento save() {
        return new Memento(this);

    }

    public void restore(Memento memento) {
        this.index = memento.savedIndex;
    }

    @Override
    public boolean hasNext() {
        return this.index < elements.size();
    }

    @Override
    public E next() {
        return elements.get(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}