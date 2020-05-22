if (previous == null) {
    newNode.next = current;
    first = newNode;
}
else {
    newNode.next = current;
    previous.next = newNode;
}