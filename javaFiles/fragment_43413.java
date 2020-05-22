void inOrderForMinimum( TreeNode node, int[] min ) {
    if ( node != null && min[0] == -1 ) {
       inOrderForMinimum( node.getLeftChild(), min );
       if ( !node.isDeleted() ) {
          min[0] = node.value;
       }
       inOrderForMinimum( node.getRightChild(), min );
   }
}