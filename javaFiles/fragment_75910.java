public void insert(int data) {
    Link newLink = new Link(data);
    if (current == null) { 
        current = newLink;
        tail = newLink;
        newLink.next = newLink; // tail.next = current!
    } else {
        tail.next = newLink; // tail.next = current!
        newLink.next = current;
        current = newLink; // tail is unchanged, newLink is current
    }
}