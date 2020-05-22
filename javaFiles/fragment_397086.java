public void visit(Hierarchical h) {
    // do something with h
    Iterator<Hierarchical> children = h.getChildren();
    while(children.hasNext()) {
        visit(children.next());
    }
}