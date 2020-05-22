while (curr != null) {
    if (curr.getElement() != null) {
        if (temporaryMinimum.compareTo(curr.getElement()) > 0) {
            min = curr;
            temporaryMinimum = curr.getElement();
        } 
    }
    curr = curr.getNext();
}