public Token remove(int index) {
    if (index<0 || index >=size()) {
        throw new IndexOutOfBoundsException();
    }
    Node ref = head;
    for (int i = 0; i < index; i++) {
        ref = ref.next;
    }
    if (index == 0) {
        head = ref.next;
    } else {
        ref.previous.next = ref.next;
    }
    size--;
    return ref.getObject();
}