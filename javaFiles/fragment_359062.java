Node searchRecursive(Node root_node, String key) 
{ 
    //Node someNode = new Node(key);

        /**
         * TODO
         * 
         */

     //Node someNode = new Node(key);
    if(root_node == null || root_node.key.equals(key)) {
        return root_node;
    }

    if(key.compareTo(root_node.key) > 0) {
        return searchRecursive(root_node.right, key);
    }

    return searchRecursive(root_node.left, key);   
}