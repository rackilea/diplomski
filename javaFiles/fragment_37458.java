public void RemoveBefore(int nodeValue) 
{
    Node curr = start;  
    Node previous = null;

    while (curr != null) 
    {
        Node next = curr.next; 

        if (next!= null && next.nodeValue == nodeValue) 
        {                   
            if( previous == null) {
                start = next;         // change directly the start of the list
            } else {
                previous.next = next; // point to next instead of curr   
            }
            return;
        }
        previous = curr;
        curr = curr.next;
    }
}