public void print() {// simple print function
    for (Node i = head; i != null && i != tail; i = i.getNext()) {
        System.out.print(i.getC());
    }
    System.out.println(tail.getC());
}