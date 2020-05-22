if( current == head ) // sure its the head but..
        {
            if( head.next != null ) // is the list NOT EMPTY?
            {
                newLink.next = head;
                head = newLink;
            }
            else // list is empty
            {
                head = newLink;
            }
        }