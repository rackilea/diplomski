obj pop() {
    if (head == null & tail == null)
        System.out.println("The stack is empty, Operation failed.");
    else {
        pops++;
        if (this.head == this.tail) {
            System.out.println("This is the last element; the stack is empty now");
            obj ret = new obj(this.head.field());
            this.head = null;
            this.tail = null;
            return ret;
        } else {
            obj ret = new obj(this.head.field());
            this.head = this.head.next();
            return ret;
        }
    }
    return null;
}