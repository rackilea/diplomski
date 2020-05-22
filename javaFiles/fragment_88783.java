public void printBackwardsList() {
    DNode temp = this.tail;
    while(temp != null) {
        System.out.println(temp);
        temp = (DNode) temp.getPrev();
    }
}