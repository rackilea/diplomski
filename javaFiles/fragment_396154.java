while (i < count) {
    if (i == pos) {
        DLLNode tmp = posFind.next;
        posFind.next = current;
        current.prev = head;  <----- here!!!
        current.next = tmp;
        tmp.prev = current;
    }
    posFind = posFind.next;
    i++;
}