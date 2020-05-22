void aAsc(int e)
    {
    Node node = new Node();
    node.element = e;
    if(start==null)
        {
        start = node;
        }


    Node p=start;

    while(p.next!=null){
        if(p.next.element>e) {
            node.next = p.next;
            p.next = node;
            break;
        }
            p=p.next;
    }

    }