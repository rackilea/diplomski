private static int testTreeRecursiveCounts(tree) {
    int count =0;
    if (tree instanceof  binaryTree) {
        count++;
        for (Node node :tree.getChild())) {
           count += testTreeRecursiveCounts((tree)node);
        }
    }
    return count;
}