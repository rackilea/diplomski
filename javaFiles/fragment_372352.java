while (cur != null && cur.next != null)
    {        
        if (data < cur.next.data)
        {
            newNode.next = cur.next;
            newNode.prev = cur;
            cur.next.prev = newNode;
            cur.next = newNode;

            return head;
        }

        else
        {
            cur = cur.next;
        }
    }