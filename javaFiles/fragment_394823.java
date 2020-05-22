if (this.next == null || this.data > item.data) { // pseudo code for greater than
    item.next = this.next;
    this.next = item;
    return;
}
this.next.insert(item);