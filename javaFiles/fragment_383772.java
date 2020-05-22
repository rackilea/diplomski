public class Main
{
  public static void main(String[] args)
  {
    BinaryTree tree = new BinaryTree();

    tree.add(20);
    tree.add(10);
    tree.add(30);
    tree.add(15);
    tree.add(25);
    tree.add(5);
    tree.add(35);
    tree.add(1);
    tree.add(6);
    tree.add(14);
    tree.add(16);
    tree.add(24);
    tree.add(26);
    tree.add(34);
    tree.add(36);


    int level = tree.getLevel(6);

    System.out.println(level);

  }
}

public class TreeNode
{
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int d){
    data = d;
    left = null;
    right = null;
  }

}

public class BinaryTree
{
  TreeNode root;

  public BinaryTree(){
    root = null;
  }

  public int getLevel(int val) {
    if (root == null) return 0;
    return getLevelHelper(root, val, 0);

  }

  public int getLevelHelper(TreeNode node, int val, int level){


    int retVal = -1;

    if (node.data == val){
      return level;
    }
    if (val < node.data && node.left != null){
      retVal = getLevelHelper(node.left, val, level + 1);
    }
    else if (val > node.data && node.right != null){
      retVal = getLevelHelper(node.right, val, level + 1);
    }

    return retVal;
  }




  public boolean add(int newData){
    if (root == null){
      root = new TreeNode(newData);
      return true;
    }
    else{
      TreeNode curr = root;
      while (true){
        if (curr.data == newData){
          return false;
        }
        else if (curr.data > newData){
          if (curr.left == null){
            curr.left = new TreeNode(newData);
            return true;
          }
          else{
            curr = curr.left;
          }


        }
        else{
          if (curr.right == null){
            curr.right = new TreeNode(newData);
            return true;
          }
          else{
            curr = curr.right;
          }
        }
      }
    }

  }
}