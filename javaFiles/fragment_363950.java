// add method for single node
public void add(T value) {
    if(head == null)
        head = new Node<T>(value);
    else {
        Node<T> temp = head;
        while(temp.next != null)
            temp = temp.next;

        tail = temp.next = new Node<T>(value);
        tail.prev = temp;
    }

    size++;
}