BTNode prev;

void BinaryTree2DoubleLinkedList(BTNodes root, BTNodes[] head)
{
    // Base case
    if (root == null) return;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls

    // Recursively convert left subtree
    BinaryTree2DoubleLinkedList(roor.getLeft(), head);

    // Now convert this node
    if (prev == null)
        head[0] = root;
    else
    {
        root.setLeft(prev);
        prev.setRight(root);
    }
    prev = root;

    // Finally convert right subtree
    BinaryTree2DoubleLinkedList(root.getRight(), head);
}