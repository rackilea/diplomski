/**
   * This returns the adjacent nodes to an integer node in the tree
   * @param node
   * @return a set of adjacent nodes, and null otherwise
   */
  public Set<Integer> getAdjacentsToNode(Integer node) {

    for (int i = 0; i < tree.size(); i++) {
      Set<Integer> level = tree.get(i);
      if (level.contains(node) && i < tree.size() - 1) {
        return tree.get(i + 1);
      }
    }
    return null;
  }