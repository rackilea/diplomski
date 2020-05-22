public T removeFirst() throws EmptyCollectionException {
    // Checking to see if the List is empty or not
    if ( isEmpty() )
        throw new EmptyCollectionException("LinkedList");

    Node<T> first = contents;

    contents = contents.getNext();
    count--;

    return first.getItem();
}