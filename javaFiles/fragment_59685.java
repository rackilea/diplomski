else {
    Node node = new Node(custPair, null);
    node.next = head;
    head = node;
    size++;
}