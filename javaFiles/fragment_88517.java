Node<E> newNode = new Node<E>( o, null );
if ( head == null ) {
    head = newNode;
} else {
    newNode.next = head;
    head = newNode;
}