public void delete_node(int data){
    node ptr=head;
    if(ptr == null)
        return;
    //if 1st node is to be Deleted
    if(ptr != null && ptr.data==data){
        head=ptr.link;
        ptr.link=null;
    }

    while(ptr.link != null && ptr.link.data!=data){
        ptr=ptr.link;
    }
    if(ptr.link != null)
        ptr.link=ptr.link.link;

}