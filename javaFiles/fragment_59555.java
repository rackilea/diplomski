public class Addtwo {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        public static void main(String args[]) {
            /* Start with the empty list. */
            Node head = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            head.next = second;
            second.next = third;

            Node iterator = head;
            while (iterator != null) {
                System.out.println(iterator.data);
                iterator = iterator.next;
            }
        }
    }
}