class LList {
    Node head;

    void reverse() {
        head = rev(head, head.next);
    }

    private Node rev(Node node, Node next) {
        if(next == null)    return node; //return the node as head, if it hasn't got a next pointer.
        if(node == this.head)   node.next = null; //set the pointer of current head to null.

        Node temp = next.next;
        next.next = node; //reverse the pointer of node and next.
        return rev(next, temp); //reverse pointer of next node and its next.
    }
}

class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}