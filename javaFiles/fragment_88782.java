public void printList() {
    DNode temp = this.head;
    while (temp != null) {
        System.out.println(temp);
        temp = (DNode) temp.getNext();
    }

}