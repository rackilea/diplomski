if(ptr.data>=newn.data)
{
    newn.next=ptr;
    ptr.prev=newn;
    newn.prev=null;
    head=newn;
    break;
}