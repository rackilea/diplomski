public void insertNodeAtParticularLocation(int x) {
        if (first == null || x < first.data) {
            // if the value that needs to be inserted
            // is less than the first element, or it does not exist,
            // then insert it at the very beginning
            insertFirst(x);
        } else {
            Link previous = first;
            Link current = first.next;
            while(current != null && current.data > x) {
                previous = current;
                current = current.next;
            }
            Link newNode = new Link(x);
            previous.next = newNode;
            newNode.next = current;
        }
    }