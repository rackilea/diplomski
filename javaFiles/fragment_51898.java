public void add(String data){
    Node linkedTemp = new Node(data);
    Node linkedCurrent = head;
    Node linkedPrev = head;
    while ( linkedCurrent != null ) {
        if ( linkedCurrent.getData() != null && linkedCurrent.getData().compareTo(data) > 0 ) {
            break;              
        }
        linkedPrev = linkedCurrent;
        linkedCurrent = linkedCurrent.getNext();
    }
    linkedTemp.setNext( linkedPrev.getNext() );
    linkedPrev.setNext(linkedTemp);
    listCount++;
}