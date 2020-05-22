public ListIterator<E> listIterator(int index) {
    if ((index < 0) || (index > size)) {
        throw new IndexOutOfBoundsException("index " + index+ " is out of range: 0 to " + size);
    }
    return new LinkedListIterator<E>(index);
}