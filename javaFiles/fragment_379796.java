if (isOperator(ch))
{
    TreeNode rightNode = nodes.pop();
    TreeNode leftNode = nodes.pop();
    nodes.push(new TreeNode(leftNode, ch, rightNode));
}
else if (!Character.isWhitespace(ch))
{
    nodes.add(new TreeNode(null, ch, null));
}