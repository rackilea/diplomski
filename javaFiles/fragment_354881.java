public int minDepth(TreeNode root) {
    ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
    q.offer(new Pair(root, 1));

    while (!q.isEmpty()) {
        Pair<TreeNode, Integer> curr = q.poll();

        if (curr.first != null) {
            if (curr.first.left == null && curr.first.right == null) {
                return curr.second;
            }

            q.offer(new Pair(curr.first.left, curr.second + 1));
            q.offer(new Pair(curr.first.right, curr.second + 1));
        }
    }

    return 0;
}