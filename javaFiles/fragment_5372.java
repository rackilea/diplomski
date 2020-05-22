public static void rightView(TreeNode tNode){
    int maxLevel = 0;
    rViewUtil(tNode, 1,maxLevel);
}

public static int rViewUtil(TreeNode tNode, int level, int maxLevel){
    if(tNode==null)
        return;
    if(maxLevel < level){
        System.out.print(tNode.value + " ");
        maxLevel = level;
    }
    maxLevel = rViewUtil(tNode.right, level+1, maxLevel);
    maxLevel = rViewUtil(tNode.left, level+1, maxLevel);
    return maxLevel
}