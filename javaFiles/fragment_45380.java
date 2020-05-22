static boolean hasPathSumBert(final Node node, final int sum) {
    // return true if we run out of tree and sum==0
    if (node == null) {                                   // empty tree
        // choose one:
        return (sum == 0);
        //return false;
    } else if (node.left == null && node.right == null) { // leaf
        return (sum == node.data);
    } else if (sum <= node.data) {                        // sum used up
        return false;
    } else {                                              // try children
        return (node.left != null  && hasPathSumBert(node.left, sum - node.data)) ||
               (node.right != null && hasPathSumBert(node.right, sum - node.data));
    }
}