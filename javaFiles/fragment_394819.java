Node save = this.first;
this.first = this.first.next;

insertHelper(this.first, item);

if (pointer.data.compareTo(item) > 0) {
    save.next = store;
    this.first = save;
} else {
    save.next = pointer;
    this.first = save;
}