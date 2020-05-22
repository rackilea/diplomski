else
{
    temp = head;
    // Get last item
    while (temp.next != null)
    {
        temp = temp.next;
    }
    // Point old last item to *new* last item
    temp.next = new Node(d, c, null); 
}