Node prev = null;
Node curr = head;
Node next;

while (curr != NULL)
{
    next  = curr.next;  
    curr.next = prev;   
    prev = current;
    current = next;
}
head = prev;