public void addFirst(E e) {
    head = new Node<E>(e, head); // update here
    if(size == 0){
        tail = head;
    }
    size++;
}

public void addLast(E e){
    Node<E> newest = new Node<E>(e, null); // update here
    if(isEmpty()){
        head = newest;
    }
    else{
        tail.setNext(newest);
    }
    tail = newest;
    size++;
}