public boolean containsValue(Node node, Value value){
    int result = node.value.compareTo(value);
    if(result == 0){
        return true;
    }else if(result < 0){
        if(node.left != null){
            return containsValue(node.left, v);
        }
        return false;
    }else{
        if(node.right != null){
            return containsValue(node.right, v);
        }
        return false;
    }
}