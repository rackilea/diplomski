Node insertRecursive(Node root_node, String key) { 
    /**
     * TODO
     * 
     */
    Node someNode = new Node(key);
    if(root_node != null) {
        int comparison = someNode.getKey().compareTo(root_node.getKey());

        if(comparison < 0) {
            root_node.left = insertRecursive(root_node.left, key);
        }else if(comparison > 0) {
            root_node.right = insertRecursive(root_node.right, key);
        }
    }else{
        root_node = new Node(key);
    }
    return root_node;
}