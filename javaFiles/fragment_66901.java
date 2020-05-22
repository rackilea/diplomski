private Q(int c, LinkedList<Object> ll) {
    this.capacity = c;
    this.ll = ll;
}

public Q split() {
    List<Object> secondHalf = this.ll.subList(this.ll.size() / 2, this.ll.size());
    Q newQ = new Q(this.capacity, new LinkedList<>(secondHalf));
    secondHalf.clear();
    return newQ;
}