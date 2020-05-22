@Override
public void add(final int index, final E element) {
    final int size = decorated().size();
    if (index > size) {
        decorated().addAll(Collections.<E>nCopies(index - size, null));
    }
    decorated().add(index, element);
}