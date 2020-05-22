public void add(int data){
    if(this.root == null){
        this.root = new Node(data);
    }
    else {
        this.add(this.root,data);
    }
}