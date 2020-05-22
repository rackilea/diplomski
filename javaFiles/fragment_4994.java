public void insert(String data){

    Node tmp = new Node(data,null,null);
    tmp.data=data;
    tmp.next=null;

    if(head==null){
        head=tail=tmp;
        head.prev=null;
    }
    else{
        tail.next=tmp;
        tmp.prev=tail;
        tail=tmp;
    }
    size++;
}