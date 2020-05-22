public void add(int index, Node item) {
    if (index > size) throw new IndexOutOfBoundsException();

    Node cursor = head.next;
    int i = 0;
    while (i < index) {
        i++;
        cursor = cursor.next;
    }

    item.next = cursor.next;
    item.next.prev = item;
    cursor.next = item;
    item.prev = cursor;
    size++;
}