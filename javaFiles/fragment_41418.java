public class BinaryTree { 

private Node root; 

public BinaryTree() { 
    root = null; 
} 


public void buildTree(Node rt, Node lChild, Node rChild) { 
  root = rt; 
  root.left  = lChild; 
  root.right = rChild;
}

public int size() { 
    return(size(root)); 
}
private int size(Node node) { 
    if (node == null) return(0); 
    else { 
        return(size(node.left) + 1 + size(node.right)); 
    } 
}

public int maxDepth() { 
    return(maxDepth(root)); 
}
private int maxDepth(Node node) { 
    if (node==null) { 
        return(0); 
    } 
    else { 
        int lDepth = maxDepth(node.left); 
        int rDepth = maxDepth(node.right);

        // use the larger + 1 
        return(Math.max(lDepth, rDepth) + 1); 
    } 
}

public void printTree() { 
    printTree(root); 
    System.out.println(); 
}
private void printTree(Node node) { 
    if (node == null) return;
    printTree(node.left); 
    System.out.print(node.data + "  "); 
    printTree(node.right); 
}

public void printPostorder() { 
    printPostorder(root); 
    System.out.println(); 
}

public void printPostorder(Node node) { 
    if (node == null) return;

    printPostorder(node.left); 
    printPostorder(node.right);

    System.out.print(node.data + "  "); 
}

public Node getRootNode() {
    return root;
}

public int getNodeDepth() {
    return root.depth;
}

public Node getRChildNode() {
    return root.right;
}

public Node getLChildNode() {
    return root.left;
}
}