public abstract class SequenceIterator<E> implements Iterator<E> {
    private boolean searchExhausted = false;
    private E next;
    private boolean hasNext;
    private boolean nextInitialized;

    public abstract E nextInSequence();

    @Override public boolean hasNext() {
        if (!nextInitialized)
            initNext();
        return hasNext;
    }

    @Override public E next() {
        if (!nextInitialized)
            initNext();
        if (!hasNext())
            throw new NoSuchElementException();
        nextInitialized = false;
        return next;
    }

    private void initNext() {
        hasNext = false;
        nextInitialized = true;

        if (!searchExhausted) {
            next = nextInSequence();
            hasNext = next != null;
        }
    }
}