public void delStudent(int regN) {
    Node current = head;
    Node previous = head;       
    while (current != null ){ // keep traversing till end of list
        if (current.getStudent().getRegN() == regN) { // found it!
            previous.link = current.link; // relink
            if (current == head){ // edge case : removed first element
                head = current.link; // move head forward.
            }
            break;
        } else {
            previous = current;
            current = current.link;
        }   
    }
}