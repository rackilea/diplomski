public void preorder(Node n, ArrayList<String> elementAccumulator) {
  elementAccumulator.add(n.getValue());
  if(n.getLeft() != null) { preorder(n.getLeft(), elementAccumulator); }
  if(n.getRight() != null) { preorder(n.getRight(), elementAccumulator); }

}