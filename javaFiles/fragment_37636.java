public static int countLeaves(TreeNode<Integer> root)
    {
// TODO Auto-generated method stub
        int leaves = 0;
        if(root==null)
        {
            return 0;
        }
        if(root.children.size()==0)
        {
            return 1;
        }

        for(int i = 0; i < root.children.size(); i++) 
        {
            leaves += countLeaves(root.children.get(i));
        }

        return leaves;
    }
public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode<Integer> root = takeInputLevelWise();
        printTree(root);

        System.out.println(countLeaves(root));
}