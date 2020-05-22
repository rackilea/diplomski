public Node getNode(Node node, Value value){
    int result = node.value.compareTo(value);
    if(result == 0){
        return node;
    }else if(result < 0){
        if(node.left != null){
            return containsValue(node.left, v);
        }
        return null;
    }else{
        if(node.right != null){
            return containsValue(node.right, v);
        }
        return null;
    }
}