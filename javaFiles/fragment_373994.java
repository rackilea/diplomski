public class LinkedList {
    Node head;
    int size; // Maybe

    public void insertAtEnd(int data) {
        Node previous = null;
        for (Node current = head; current != null; current = current.next) {
            previous = current;
        }
        Node baby = new Node(data);
        if (previous == null) {
            head = baby;
        } else {
            previous.next = baby;
        }
        ++size;
    }

    public void insertInSortedList(int data) {
        Node previous = null;
        Node current = null;
        for (current = head; current != null && data < current.data;
                current = current.next) {
            previous = current;
        }
        Node baby = new Node(data);
        baby.next = current;
        if (previous == null) {
            head = baby;
        } else {
            previous.next = baby;
        }
        ++size;
    }
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}