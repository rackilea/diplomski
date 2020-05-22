public static int getMaxDepth(BTreeNode root) {
    if (root == null) return 0;
    List<BTreeNode> currentLayer = new ArrayList<>();
    List<BTreeNode> children = new ArrayList<>();
    int depth = 0;

    currentLayer.add(root);
    while (0 < currentLayer.size()) {
        depth++;

        children.clear();
        for (BTreeNode node : currentLayer) {
            BTreeNode left = node.getLeftChild();
            if (left != null) children.add(left);

            BTreeNode right = node.getRightChild();
            if (right != null) children.add(right);
        }

        currentLayer.clear();
        currentLayer.addAll(children);
    }

    return depth;
}