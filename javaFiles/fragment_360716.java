public Link delete() {
    Link temp = first;
    if(first == null){
        ;  // or you can throw some exception as a warning
    }
    else if(first==last){  // only one element
        first = null; // reset to initial state
        last = null;
    }
    else{
        first = first.next;
        last.next = first;
    }
    return temp;
}