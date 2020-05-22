static Child addChild(Child c, Child tree){
    if(tree==null){
        return c;
    }
    else{
        if(c.cid>tree.cid){
            tree.lc = addChild(c, tree.lc);
        }
        else if(c.cid<tree.cid){
            tree.rc = addChild(c, tree.rc);
        }
        return tree;
    }
}