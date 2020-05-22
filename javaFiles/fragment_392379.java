private Node getNode(Node root, Object c) {
    String datac = String.valueOf(c);
    if(root == null) return null;
    if(Objects.equals(datac, root.data)) return root;
    Node tmp;
    return ((tmp = getNode(root.left, c)) != null) ? tmp : getNode(root.right, c);
}