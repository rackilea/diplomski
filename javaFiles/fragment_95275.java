public boolean isMobile() {
  return isMobile(root);
}

private boolean isMobile(Node n) {
  if ( n == null || n.left == null ) return true;
  return isMobile(n.left) && isMobile(n.right) && weight(n.left) == weight(n.right);
}