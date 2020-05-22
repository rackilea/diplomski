public int countNodes(Node root){
    if(root == null){
        System.out.println("The tree is empty!");
        return 0;
    } 
    else{
        Node current = root;
        int count = 0 
        if(current.leftChild != null){
            count +=  countNodes(current.leftChild)+1;
        }
        if(current.rightChild != null){
            count += countNodes(current.rightChild)+1;
        }
        return count;
    }
}