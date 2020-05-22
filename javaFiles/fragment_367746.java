public static boolean checkBST(TreeNode n) {
    WrapInt counter = new WrapInt();
    return checkBST(n, counter);
}

public static boolean checkBST(TreeNode n, WrapInt counter) {
    if(n == null) return true;

        // Check / recurse left
        if (!checkBST(n.left, counter)) return false;

        // Check current
        if (n.data <= counter.value) return false;
        counter.value = n.data;

        // Check / recurse right
        if (!checkBST(n.right, counter)) return false;

        return true; // All good!
}