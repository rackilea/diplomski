public static Node merge(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        } else {
            return new Node(n1.value, merge(n1.next, n2));
        }
    }

    static Node reverse(List<Integer> list) {
      return list.stream()
        .reduce(
          (Node) null, //the empty element
          (n, i) -> new Node(i, n) , //combining a Node and an Integer
          (n1, n2) -> merge(n1, n2)); // combining two Nodes
    }