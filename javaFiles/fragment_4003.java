Node node = new Node(1);
 node.add(2);
 node.add(4);
 node.add(3);
 node.delete(3);
 node = node.delete(1);
 node.printList();