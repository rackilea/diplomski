public BinaryTreeNode<Type> inorderSuccessor(BinaryTreeNode<Type> root,BinaryTreeNode<Type> t,BinaryTreeNode<Type> successor)
{
    if(root==null)
        return null;
    if(root.element==t.element)
    {
        if(root.right!=null)
            return findMin(root.right);
        else
            return successor;
    }
    int cmp=t.element.compareTo(root.element);

    if(cmp < 0)
        return inorderSuccessor(root.left,t,root);
    else
        return inorderSuccessor(root.right,t,successor);
}

public BinaryTreeNode<Type> findMin(BinaryTreeNode<Type> t)
{
    if(t==null)
        return t;
    while(t.left!=null)
        t=t.left;
    return t;
}