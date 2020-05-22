public void insertAt( String data, int pos )
{
    if( head == null )
    {
        head = new Node( data );
    }
    else
    {
        Node newLink = new Node(data);
        Node current = head , prevToCurrent = null;
        for( int x = 1; current != null && x < pos; x++ )
        {
            prevToCurrent = current;
            current = current.next;
        }
        if( current == head )
        {
            if( head.next != null )
            {
                newLink.next = head;
                head = newLink;
            }
            else
            {
                head = newLink;
            }
        }
        else if( current == null )
        {
            prevToCurrent.next = newLink;
            newLink.prev = prevToCurrent;
        }
        else
        {
            current.prev.next = newLink;
            newLink.prev = current.prev.next;

            newLink.next = current;
            current.prev = newLink;
        }
    }
    size++;
}