public static void LevelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode tmp = q.remove();
        if (tmp == null) {
            continue;
        }
        System.out.print(tmp.data + " ");
        q.add(tmp.left);
        q.add(tmp.right);
    }
}