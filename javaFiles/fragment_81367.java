if (key < focusNode.key) {
    focusNode = focusNode.leftChild;

    if (focusNode == null) {
        parent.leftChild = newNode;
        return;
    }
} else {
    focusNode = focusNode.rightChild;

    if (focusNode == null) {
        parent.rightChild = newNode;
        return;
    }
}