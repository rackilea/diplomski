int countNrOfInnerNodes (Node node) {
    if(node == null) {
       return 0;
    }

    if (node.left == null && node.right == null) {
       // not an inner node !
       return 0;
    } else {
       // the number of inner nodes in the left sub-tree + the number of inner
       // nodes in the right sub-tree, plus 1 for this inner node
       return countNrOfInnerNodes(node.left) + countNrOfInnerNodes(node.right) + 1;
    }
}