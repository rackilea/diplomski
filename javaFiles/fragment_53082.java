public static TreeNode constructBFSTree(ArrayList<Integer> bfs) {
    if (bfs == null || bfs.isEmpty()) {
        return null;
    }

    Queue<TreeNode> q = new Queue<TreeNode>();
    TreeNode root = new TreeNode(bfs.get(0));
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < bfs.size()) {
        TreeNode currentNode = q.poll();
        currentNode.left = new TreeNode(bfs.get(i++));
        q.add(curentNode.left);
        if (i < bfs.length()) {
            currentNode.right = new TreeNode(bfs.get(i++));
            q.add(currentNode.right);
        }
    }
    return root;
}