public String remove(){

    if(head == null)
        return null;// list empty
    Node tmp=head.next;
    head.next=tmp.next;
    tmp.next.prev=head;
    size--;
    list();
    return tmp.data;
}