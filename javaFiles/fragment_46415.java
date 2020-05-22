class Solution {
    // no class or instance variables at all

    public int kthSmallest(TreeNode root, int k) {
        // int[1] is the simplest mutable container for an int
        int[] result = new int[1];
        inorder(root, k, result);
        return result[0]; 
    }

    // does not need to be public:
    // returns the number of nodes traversed (not necessarily the whole subtree)
    int inorder(TreeNode root, int k, int[] result) {
        if (root == null) {
            return 0;
        } else {
            // nodes traversed in the subtree, plus one for the present node
            int count = inorder(root.left, k, result) + 1;

            if (count == k) {
                result[0] = root.val;
            } else {
                count += inorder(root.right, k, result);
            }

            return count;
        }
    }
}