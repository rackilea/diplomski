public void add(Node subroot, int data){
    if(data > subroot.data){
        addRight(subroot,data);
    }
    else if(data < subroot.data){
        addLeft(subroot,newNode);
    }
}

private void addLeft(Node subroot, int data) {
    if(subroot.leftChild == null){
        subroot.leftChild = new Node(data);
    }
    else {
        add(subroot.leftChild,data);
    }
}

private void addRight(Node subroot, int data) {
    if(subroot.rightChild == null){
        subroot.rightChild = new Node(data);
    }
    else {
        add(subroot.rightChild,data);
    }
}