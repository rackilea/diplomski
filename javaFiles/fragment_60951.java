class LinkedList {
    private Node head = null;
    private Node tail = null;

    public LinkedList() {}

    public LinkedList(Node e) {
        head = e;
        tail = e;
    }
}

class Node {
    Node next = null;
    // other data
}