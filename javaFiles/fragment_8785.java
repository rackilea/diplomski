public class GamerList {

    private class Node {

        String name;
        int score;
        Node next;

        Node(String val1, int val2, Node n) {

            name = val1;
            score = val2;
            next = n;
        }

        Node(String val1, int val2) {

            this(val1, val2, null);
        }
    }

    private Node head;
    private Node tail;

    /**
     * Constructor.
     */

    public GamerList() {

        head = null;
        tail = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {

        return head == null;
    }

    /**
     * The size method returns the length of the list.
     * @return The number of elements in the list.
     */
    public int size() {

        int count = 0;
        Node p = head;

        while(p != null) {

            count++;
            p = p.next;
        }

        return count;
    }

    public void insert(String name, int score) {

        Node node = new Node(name, score);

        if(isEmpty()) {

            head = node;
            head.next = tail;
        }
        else if(head.score <= node.score) {

            node.next = head;
            head = node;
        }

        else {
            Node beforeNode = head;
            while(beforeNode.score > node.score && beforeNode.next != null) {
                beforeNode = beforeNode.next;
            }
            node.next = beforeNode.next;
            beforeNode.next = node;
        }

        if(size() > 10) {

            Node currentPtr = head;

            for (int i = 0; i < 9; i++) {
                currentPtr = currentPtr.next;
            }
            currentPtr.next = null;
        }
    }

    public void printList() {

        Node temp = head;

        while(temp != null) {

            System.out.print(temp.name + " " + temp.score + " ");
            System.out.println("");
            temp = temp.next;
        }
    }

}