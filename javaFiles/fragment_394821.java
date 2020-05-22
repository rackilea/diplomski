public void insert(Comparable item) {
   // if there isn't anything in the list, the new item becomes the whole list
   if (first == null) {
        Node store = new Node(item);
        store.next = null;
        this.first = store;
        return;
    }

    // Otherwise let the helper fix up the list for us to store away
    this.first = insertHelper(this.first, item);
}

public Node insertHelper(Node pointer, Comparable item) {
    Node store = new Node(item);

    if (pointer.data.compareTo(item) > 0 ) {
        store.next = pointer; // new item goes in front of this part of list
        return store;
    }

    if (pointer.next == null) {
        return store; // new item becomes this part of the list
    }

    // The head of this part of the list is ok, fix the rest of the list

    pointer.next = insertHelper(pointer.next, item);
    return pointer;
}