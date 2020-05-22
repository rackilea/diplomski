Node head = new Node(0);
Node node = head.next;  // this is null
for (int i = 0; i < 20; i++) {
    node = new Node(i);
    node = node.next;   // this is null
}
// none of the above nodes have been assigned a value for "next".

node = head;
while (node != null) {
    System.out.print(node.data); // contains node.data = 0 from head
    node = node.next;  // this is null since it was never assigned
                       // a value, so loop exits on next inspection
                       // of "node != null".
}