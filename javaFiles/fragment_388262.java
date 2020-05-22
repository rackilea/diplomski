static void breadthFirstVisit(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.println("visiting node with value " + node.val);
        // visit(visitedNode)
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}