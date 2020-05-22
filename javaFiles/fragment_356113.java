public int checkTree(){
    if(left == null && right == null){
        return 1;
    }else if(left == null){
        return 1 + right.checkTree();
    }else if(right == null){
        return 1 + left.checkTree();
    }else{
        return 1 + left.checkTree() + right.checkTree();
    }
}

public void insert(BinaryTree bt){
    if(left == null){
        setLeft(bt);
    }else if(right == null){
        setRight(bt);
    }else{
        if(left.checkTree() <= right.checkTree()){
            left.insert(bt);
        }else{
            right.insert(bt);
        }
    }
}