public void addItemRequest(Node head, int item, int position)
{
    Node prevNode = head; 
    Node newNode = new Node(item,null); 

    if (head==null)
    {
        head=newNode; 
        return;
    }

    if (position == 0)
    {
        newNode.next = head; 
        head = newNode; 
        return;
    }    

    int count = 0;
    while (count < position -1 && head.next != null)
    {
        prevNode = prevNode.next;        
        count++;       
    }
    newNode.next = prevNode.next;
    prevNode.next = newNode;      
    return;
}