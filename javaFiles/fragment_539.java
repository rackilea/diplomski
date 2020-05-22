@Override
public String toString() {
    return String.valueOf(mVal);
}
public String inOrder(Tree root) {
    List<Tree> inOrder = new ArrayList<>();
    inOrderRecursively(root, inOrder);
    return inOrder.toString();
}

private void inOrderRecursively(Tree Node, List<Tree> inOrder) {
    if (Node.mLeft != null) {
        inOrderIt(Node.mLeft, inOrder);
    }
    inOrder.add(Node);
    if (Node.mRight != null) {
        inOrderIt(Node.mRight, inOrder);
    }
}