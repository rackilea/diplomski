public static void arraywriter(TreeNode<String> node, int pos) throws FileNotFoundException
{
    outputform.set(pos, node.getElement());
    pos = pos*2;
    if(node.getLeft() != null) {
        arraywriter(node.getLeft(), pos);
    }
    pos = pos+1;
    if(node.getRight() != null) {
        arraywriter(node.getRight(), pos);
    }
}