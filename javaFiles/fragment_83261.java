public void add(E item) {
    Node cursor;
    if (isEmpty( )) {
       // Insert first item.
        rear = new Node<E>(item, null);
        rear.setLink(rear);    // <=== add a link to itself to make it circular
    }
    else {
        // Insert an item that is not the first.
        rear.addNodeAfter(item);
        rear = rear.getLink( );  
    }
    manyNodes++;
}