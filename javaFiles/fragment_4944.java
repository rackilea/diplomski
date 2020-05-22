node = head;
    while (node != null) {
        if (node.data == data){
            //now you want to delete node
            if(node.previous != null) node.previous.next = node.next;
            if(node.next != null) node.next.previous = node.previous;
            return true; //found 
        }        
        node = node.next;
    }
    return false; //not found