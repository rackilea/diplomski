public void visit(Hierarchical h) {
    List<Hierarchical> branches = new LinkedList<>();
    Iterator<Hierarchical> children = h.getChildren();

    while(children.hasNext()) {
        Hierarchical h = children.next();
        // do something with h
        if(h.hasChildren()) {
            branches.add(h);
        }
    }

    for(Hierarchical branch : branches) {
        visit(branch);
    }
}