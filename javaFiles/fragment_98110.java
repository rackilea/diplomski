public Node add(String element, Node bstree)
{ 
    if (root == null)
    {
        root = new Node(element);
        return root;
    }

    if (bstree == null)
    {
        return new Node(element);
    }
    else if (element.compareTo(bstree.value) < 0)
    {
        bstree.leftChild = add(element, bstree.leftChild);
    }
    else
    {
        bstree.rightChild = add(element, bstree.rightChild);
    }

    return bstree;
}