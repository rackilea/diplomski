static Node reverse(List<Integer> list) {
      return list.stream()
        .reduce(
          (Node) null, //the empty element
          (n, i) -> new Node(i, n) , //combining a Node and an Integer
          (n1, n2) -> new Node(n1.value, n2)); // could be anything
    }