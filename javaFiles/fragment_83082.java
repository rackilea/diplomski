private TreeNode searchNodeBeingDeleted(Comparable c, TreeNode node)
 {  
  if(node == null) 
  {
   return null;
  }

  if(c.equals((Comparable)node.getValue()))
  {
   System.out.println("Here");
   return node;
  }
  else
  {
   if(node.getLeft() != null)
   {
    System.out.println("left");
    TreeNode n = searchNodeBeingDeleted(c, node.getLeft());
    if (n != null) {
      return n;
    }
   }
   if(node.getRight() != null)
   {
    System.out.println("right");
    TreeNode n = searchNodeBeingDeleted(c, node.getRight());
    if (n != null) {
      return n;
    }
   }
  }
  return null; //i think this gives me my null pointer at bottom
 }