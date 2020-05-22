public void output(Tree tree) {
    System.out.println(tree.nodeString());
    for(int i = 0; i < tree.numChildren(); i++) {
        output(tree.children()[i]);
    }
}