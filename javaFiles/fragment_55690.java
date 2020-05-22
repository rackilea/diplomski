public int size(){
    node n = head;
    node m = tail;
    if(n == null){
        return 0;
    }
    int size = 1;
    While(n!=m){
        size++;
        n=n.getNext();
    }
    return size;
}