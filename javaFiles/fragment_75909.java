public void insertAfter(int data) {
    Link newLink = new Link(data);
    if (current == null) { 
        newLink.next = newLink;
        current = newLink;
    } else {
        newLink.next = current.next;
        current.next = newLink;
    }
}