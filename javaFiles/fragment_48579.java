public IntList append(IntList y) {
    ConsCell x = start;
    while (x.getTail() != null) {
        x = x.getTail();
    }
    x.setTail(y.getStart());
    return this;
}