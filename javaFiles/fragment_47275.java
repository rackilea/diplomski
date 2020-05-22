while(true) {
    if (data <= currentNode.data) {
        if (currentNode.leftChild == null) {
            currentNode.leftChild = newNode;
            return;
        }
        else {
            currentNode = currentNode.leftChild;
        }
    else {
        if (currentNode.rightChild == null) {
            currentNode.rightChild = newNode;
            return;
        }
        else {
            currentNode = currentNode.rightChild;
        }
    }
}