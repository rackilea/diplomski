private int countEven(BSTNode root){

  if (root == null)
    return 0;

  int val = (root.value%2==1) ? 0 : 1;

  return val + countEven(root.left) + countEven(root.right);


}