/**
   * runs a DFS on the tree to retrieve all paths
   * @param tree
   */
  public void runDFS(Integer node) {
    if (getAdjacentsToNode(node) != null) {
      for (Integer adjNode : getAdjacentsToNode(node)) {
        currentPath.add(adjNode);
        runDFS(adjNode);
      }
      currentPath.remove(currentPath.size() -1);
    } else {
      paths.add(currentPath.toArray(new Integer[0]));
      currentPath.remove(currentPath.size() -1);
    }
  }