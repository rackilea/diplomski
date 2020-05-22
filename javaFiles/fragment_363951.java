// add method for specific position
// pos must be smaller/equal than the size of the list
public void addPos(int pos, T value) {
    if(pos > size) // pos must be smaller/equal than size
        return;

    Node<T> newNode = new Node<>(value);
    size++;

    if(pos == 0) {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        return;
    } else if(pos == size-1) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    } else {
        Node<T> temp = head;
        for(int i = 0; i < pos; i++)
            temp = temp.next;

        // insert newNode in the middle of temp.prev and temp
        // temp.prev <-> newNode <-> temp

        // attach newNode's prev and next references
        newNode.next = temp;
        newNode.prev = temp.prev;

        // attach adjacent node's references to newNode
        temp.prev.next = newNode;
        temp.prev = newNode;
    }
}