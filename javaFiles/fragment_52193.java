Node head = new Node(3, second);
Node node = head;
while (node.next != null) {
    System.out.println(node.toString());
    node = node.next;
}