public boolean addUniqueNode(DefaultMutableTreeNode childNode, DefaultTreeModel model)
{
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

    // Check each node
    boolean isUnique = true;
    for (int i = 0; i < model.getChildCount(root); i++)
    {
        Object compUserObj = ((DefaultMutableTreeNode) model.getChild(root, i)).getUserObject();
        if (compUserObj.equals(childNode.getUserObject()))
        {
            isUnique = false;
            break;
        }
    }

    // If Unique, insert
    if(isUnique)
        model.insertNodeInto(childNode, root, root.getChildCount());

    return isUnique;
}