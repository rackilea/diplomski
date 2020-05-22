static void breadthFirstVisit(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList();
    Set<TreeNode> visited = new HashSet();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.println("visiting node with value " + node.val);
        // visit(visitedNode)
        if (node.left != null && !visited.contains(node.left)) {
            queue.add(node.left);
            visited.add(node.left);
        } 
        if (node.right != null && !visited.contains(node.right)) {
            queue.add(node.right);
            visited.add(node.right);
        } 
    }
}