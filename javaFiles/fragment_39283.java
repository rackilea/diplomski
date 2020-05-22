public String print() {
    StringBuilder str = new StringBuilder();
    Node curr = first;
    while (true) {
        str.append(curr.getData());
        curr = curr.getNext();
        if (curr == first) break;
    }
    return str.toString();
}