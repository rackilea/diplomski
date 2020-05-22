public class RemoveDups {

    public static void main(String[] args) {

        Node head = new Node(0);
        Node node = head;
        for (int i = 1; i <= 20; i++) {
            node.next = new Node(i);
            node = node.next;
        }

        node = head;
        while (node != null) {
            System.out.printf("Current node value is: %d\n", node.data);
            node = node.next;
        }
    }
}