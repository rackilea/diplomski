public LString substring(int start, int end) {
    if (start < 0 || end > length() || start > end) {
        throw new IndexOutOfBoundsException();
    }
    LString result = new LString();
    if (start == end) {
        return result;
    }
    node node = this.front;
    for (int i = 0; i < start; i++) {
        node = node.next;
    }
    node copy = new node(node.data);
    result.front = copy;
    for (int i = start + 1; i < end; i++) {
        node = node.next;
        copy = copy.next = new node(node.data);
    }
    result.size = end - start;
    return result;
}