for(Node node : nodes) {
  RawNode raw = rawNodesByNode.get(node);
  int parentId = raw.getParentId();
  Node parent = nodesById.get(parentId);
  node.setParent(parent);
}