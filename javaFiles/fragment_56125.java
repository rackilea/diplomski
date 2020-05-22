public int elementAt(int index){
        if(index>size){
            return -1;
        }
        Node n = head;
        int i = 0; // zero-indexing
        while(i++ != index){ // you can increment i at the end too
            n=n.next;
        }
        return n.data;
    }