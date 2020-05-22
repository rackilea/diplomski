public Node insertNode(Node node, int insert_value) {
    if (node == null) {
      return new Node(insert_value);
    }
    if (node.getNodeValue() < insert_value) {
      node.setLeftNode(insertNode(node.getLeftNode(), insert_value));
    } else {
      node.setRightNode(insertNode(node.getRightNode(), insert_value));
    }
    return node;
  }