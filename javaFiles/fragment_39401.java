void push(obj el) {
    pushes++;
    if (this.head == null | this.tail == null) {
        this.head = el;
        this.tail = el;
    } else {
        el.concat(head);
        head = el;
    }
}