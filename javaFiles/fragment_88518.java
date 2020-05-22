Node<E> newNode = new Node<E>( o, null );
if ( head == null ) {
} else {
    newNode.next = head;
}
head = newNode;