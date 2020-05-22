public boolean isIn(int v, Node node){
    if(node != null){  
        if(v == node.element){
            System.out.print(node.element);
            return true;
        }
        return isIn(v, node.left) || isIn(v, node.right);

    }
    return false;
}