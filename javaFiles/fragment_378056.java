public Node findElem(Node head, int k) {
    if(k < 1 || k > this.length()) {
        System.out.println("Error");
        return null;
    }
    Node position = head;
    while(k > 0) {
        position = position.next;
        k--;
    }
    return position;
}