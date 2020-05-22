public void insert (T val) {
    Node<T> tmp;
    if (empty()) {
        current = head = new Node<T> (val);
    }
    else if(!contain(val)) { // the object val will be added only if it not exist in the list
        tmp = current.next;
        current.next = new Node<T> (val);
        current = current.next;
        current.next = tmp;
    }
}