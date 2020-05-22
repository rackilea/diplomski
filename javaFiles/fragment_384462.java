for (Node<E> trav = other.top; trav != null; trav = trav.next){

    if (top.getData().equals(trav.getData())) {
        count++;    
    }

    top = top.getNext();
}