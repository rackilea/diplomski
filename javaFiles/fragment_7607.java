public int getSameLevelNum() {
    int level = 0;
    Hierarchy current = this;
    while(current.getParentNode() != null){
        level++;
        current = current.getParentNode();
    }
    return recurse(current, level);
}

int recurse(Hierarchy node, int level){
    if(level == 0) return node.children.size();
    level--;
    int r = 0;
    for(Hierarchy child : node.children)
            r+= recurse(child, level);  

    return r;
}