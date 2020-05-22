Set<Node> closeSet = new HashSet<>();
Node n1 = new Node();
Node n2 = new Node();
closeSet.add(n1);
System.out.println(closeSet.contains(n1)); //true
System.out.println(closeSet.contains(n2)); //false - though depending upon equals/hashcode implementation of Node