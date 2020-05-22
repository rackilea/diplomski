public static String concatInOrder(StringTreeNode t)
{
    if (t == null) return "";

    return concatInOrder(t.left) + t.val + concatInOrder(t.right);
}