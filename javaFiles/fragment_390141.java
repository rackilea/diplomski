public void insertAtAnyPosition(int index, int data) {
        Node node = new Node();
        node.data = data;

        Node n = head;

        for (int i = 0; i < index-1; i++) {
            n = n.next;
        }
        Node n1 ; 
        if(n.next== null){
.       n1 = n;
}else{
       n1 =n.next.previous;
}
        node.previous = n1;
        node.next = n.next;
        n.next = node;
        n1 = node;