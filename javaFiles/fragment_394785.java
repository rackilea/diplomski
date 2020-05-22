public boolean remove(E element) {
    SLNode<E> previous = head;
    SLNode<E> current = head.getSuccessor();

    while (current != tail) {
        if (current.getElement().equals(element)) {
            previous.setSuccessor(current.getSuccessor());

            return true;
        }

        previous = current;
        current = current.getSuccessor();
    }

    return false;
}