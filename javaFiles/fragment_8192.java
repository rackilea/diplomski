TreeModel model = tree.getModel();
DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

for (int i = 0; i < root.getChildCount(); i++)
{
    DefaultMutableTreeNode child = (DefaultMutableTreeNode)root.getChildAt(i);
    System.out.println(child);

    for (int j = 0; j < child.getChildCount(); j++)
    {
        System.out.println("  - " + child.getChildAt(j));
    }
}