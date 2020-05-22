public void addToHead(T element) {
    Node<T> newNode = new Node<T>(element);
    if (head == null) {
        // This is the first node you are adding to the list.
        head = newNode;
        head.setNext(head);
        head.setPrevious(head);
    }
    else {
        // Some nodes are already present in your list.

        // Going right.
        newNode.setNext(head);
        newNode.setPrevious(head.getPrevious());

        // Going left.
        newNode.getPrevious().setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        head = newNode;
    }
}