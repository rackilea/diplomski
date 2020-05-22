//entry point - called from directing code
public void iterativePreorder(Node root) {
   iterativePreorderKernel(root, root);
}

//recursive method - keeps track of root in addition to current Node
private void iterativePreorderKernel(Node root, Node current) {

    if (current.left() != null) {
        iterativePreorderKernel(root, current.left());
    }
    if (current.right() != null) {
        iterativePreorderKernel(root, current.right());
    }

    //for each Node in the tree, do calculations on the entire tree, pretending
    //the current Node is a leaf
    doCalculation(root, current);
}

//calculation method (also recursive) - takes a current Node, plus
//the Node to treat as a leaf
public void doCalculation(Node innerCurrent, Node pretendLeaf) {

   //do calculation with inner current node

   if (innerCurrent != pretendLeaf) {
      if (innerCurrent.left() != null) {
         doCalculation(innerCurrent.left(), pretendLeaf);
      }
      if (innerCurrent.right() != null) {
         doCalculation(innerCurrent.right(), pretendLeaf);
      }
   }
}