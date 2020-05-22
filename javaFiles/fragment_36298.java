/**
 * initializes our search, sets the root and adds it to the path
 */
  public void initialize() {
    root = -1;
    for (Integer node : tree.get(0)) {
      root = node;
    }
    currentPath.add(root);
  }