Node prev = null;
while (current != null) {
    Node next = current.getNextNode()
    if(current.getNum() == N){
        //condition to remove current node has been found.
        if(prev == null){
            Head = next;
        } else {
            prev.setNextNode(next);
        }
    } else {
        //only advance prev if we haven't deleted something
        prev = current;
    }
    current = current.getNextNode();
}