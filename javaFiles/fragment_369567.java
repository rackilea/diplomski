public void reverseCDLL() {

    if (head != null) {

       Node current = head, next, temp;

       do{

           next = current.getNextNode();
           temp = current.getPrevNode();
           current.setPrevNode(current.getNextNode());
           current.setNextNode(temp);
           current = next;

       }while(current != head);
       head = head.getNextNode();
    }
}