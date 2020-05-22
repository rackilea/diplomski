/**
 * Perform an inorder search through tree.
 * The first node in order that matches the value is returned, otherwise return null.
 * @param node The given node
 * @param value The value of the node to be found.
 * @return The first node that matches the value, or null
 */
public Node inorder(Node node, Object value){
    Node result = null;
    if(node != null){
        result = inorder(node.leftChild, value);
        if( result != null) return result;

        if(node.value.equals(value)){
            System.out.println(value + " was found at " + node);
            return node;
        }
        result = inorder(node.rightChild, value);
    }
    return result;
}