if(data < cur.data) {
            newNode.next = cur;
            newNode.prev = null;
            cur.prev = newNode;

            head  = newNode;
            return head;
    }

    while (cur != null)
    {        
        if (data >= cur.data)
        {   
            if(cur.next == null) {
                 newNode.next = cur.next;
                 newNode.prev = cur;
                 cur.next = newNode;

                 return head;    
            }

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