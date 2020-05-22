protected MyListNode clone() {
    try {
        Object nodeClone = super.clone();
        ((MyListNode) nodeClone).rectangle = (Rectangle) this.rectangle.clone();
        if (this.next != null) {
            ((MyListNode) nodeClone).next = this.next.clone();
        }
        return (MyListNode) nodeClone;
    } catch (CloneNotSupportedException c) {
        throw new RuntimeException(c); // <<- This is the best for impossible conditions so if they happen you notice
    }
}