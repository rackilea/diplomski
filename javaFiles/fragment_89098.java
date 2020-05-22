private void printPostorder(Node node) {

    if (node == null) { //the tree is empty. 
        return;
    }

    int counter = node.postorderNumber;

    printPostorder(node.left); // first recur on left subtree 
    printPostorder(node.right); // then recur on right subtree
    System.out.print(node.value + " "); // now deal with the node
    counter++;
    node.postorderNumber = counter;
}