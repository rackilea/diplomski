public Node s(Node head) {
    // if fewer than 2 nodes, return.
    if (head == null || head == null) {
        return head;
    }

    // we know that the new head will be the second node.
    Node firstNode = head;
    Node parentNode = null;

    while (firstNode != null && firstNode.next != null) {
        Node secondNode = firstNode.next;
        Node secondNodeSuccessor = secondNode.next;

        // swap the nodes
        secondNode.next = firstNode;
        firstNode.next = secondNodeSuccessor;

        if (parentNode != null) {
            // This links the previous node (the one right before
            // the two that we just swapped) to the swapped nodes.
            parentNode.next = secondNode;
        }
        // the new parent node is the last swapped node.
        parentNode = firstNode;
        firstNode = firstNode.next; // set up for next pair
    }

    return head.next;
}