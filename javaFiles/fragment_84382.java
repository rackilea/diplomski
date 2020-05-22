private void checkElementIndex(int index) {
    if (!isElementIndex(index))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}

/**
 * Tells if the argument is the index of an existing element.
 */
private boolean isElementIndex(int index) {
    return index >= 0 && index < size;
}