// this loop will run forever if there are more than 1 nodes
while (nodeNext != null) {
    current.next = null;
    nodeNext.next = current; // you lose the reference to the entire list here
    current = nodeNext;
}