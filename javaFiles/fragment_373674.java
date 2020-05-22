public static void print(DefaultMutableTreeNode aNode)
{
    String name = aNode.toString();
    int level= aNode.getLevel();
    String placement = "";
    while (level > 0)
    {
        placement += ">";
        level--;
    }
    if(aNode.isLeaf())
    {
        System.out.println(placement + name);
        return;
    }

    System.out.println(placement + "--- " + name + " ---");
    for(int i = 0 ; i < aNode.getChildCount() ; i++)
    {
        print((DefaultMutableTreeNode)aNode.getChildAt(i));
    }
    System.out.println(placement + "+++ " + name + " +++");
}