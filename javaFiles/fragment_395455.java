ListIterator<E> listIter = list.listIterator(0);
while (listIter.hasNext()) {
    E element = listIter.next();
    ...
    // Remove the element last polled
    listIter.remove();
    // Inserts an element right before the last polled element
    listIter.add(new Element());
}