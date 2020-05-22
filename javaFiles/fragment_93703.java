public boolean removeNode(int x) {
    tempNode = this.head;
    prevNode = null;
    if (this.head != null && this.head.data == x) {
        this.head = this.head.next;
        return true;
    }
    while (tempNode != null) {
        if (tempNode.data == x) {
            prevNode.next = tempNode.next;
            return true;
        }
        prevNode = tempNode;
        tempNode = tempNode.next;
    }
    return false;
}