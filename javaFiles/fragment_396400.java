public void push(E x) {
    Node<E> newNode = new Node<E>(x);
    if(first == null) {
        first = newNode;
        size++;
    } else if (size==maxSize) {
        Node<E> act = first;
        // last =null;
        first = newNode;
        first.next=act;
    } else {
        Node<E> act = first;
        first = newNode;
        first.next=act;
        size++;
    }
}