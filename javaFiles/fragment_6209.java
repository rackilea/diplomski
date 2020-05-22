public static int treeDepthNonRecursion(TreeNode root) {
    int maxDepth = 0;
    int depth = 0;
    if (root == null) {
        return 0;
    }

    TreeNode node = root;
    Stack<TreeNode> nodesStack = new Stack<TreeNode>();
    Stack<Integer> depthStack = new Stack<Integer>();
    nodesStack.push(node);
    depthStack.push(depth);

    while (!nodesStack.isEmpty()) {
        node = nodesStack.pop();
        depth = depthStack.pop();
        maxDepth = Math.max(maxDepth, depth);
        if (node.getLeftChild() != null) {
            nodesStack.push(node.getLeftChild());
            depthStack.push(depth + 1);
        }
        if (node.getRightChild() != null) {
            nodesStack.push(node.getRightChild());
            depthStack.push(depth + 1);
        }
    }

    return maxDepth;
}