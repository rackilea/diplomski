void traverse (Node root) {
  traverse (root.left, root);
}

void traverse (Node current, Node parent) {
  while (current != null) {
    if (parent != null) {
      parent.left = current.right;
      current.right = parent;
    }

    if (current.left != null) {
      parent = current;
      current = current.left;
    } else {
      print(current);
      current = current.right;
      parent = null;
    }
  }
}