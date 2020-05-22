public Link delete() {
    if(first.next == null) 
        last = null;
    Link temp = first;
    first = first.next;
    if(last != null)
        last.next = first
    return temp;
}