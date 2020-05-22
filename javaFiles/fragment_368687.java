public static Node delete(Node head, int position)
{
    Node traverse = head;
    if(position == 0) { 
        //remember this case
        head = head.next;
        return head;
    }

    for(int i = 1; i < position; i++)
        traverse = traverse.next;

    Node deleteit = traverse.next; //want to skip over this node
    traverse.next = deleteit.next; 

    return head;
}