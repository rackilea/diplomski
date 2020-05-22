Child tree = new Child();
tree.cid = 0;
tree.lc = new Child();
tree.lc.cid = 1;
Child c = new Child();
c.cid = 2;
addChild(c, tree);
    // tree != null
    // c.cid>tree.cid
    addTree(c, tree.lc);
        // tree != null
        // c.cid>tree.cid
        addTree(c, tree.lc);
            // tree == null
            tree = c; // Won't be effective
        return;
    return;