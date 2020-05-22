public String printReverse() {
    return printReverse(head); 
}

private String printReverse(Node n) {
    return next == null ? "" : (printReverse(next) + n.value);
}