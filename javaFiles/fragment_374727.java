public BinaryNode parent(BinaryNode p){
    parentHelper(root,p)
}
private BinaryNode parentHelper(BinaryNode currentRoot, BinaryNode p) {        
    if (isRoot(p) || currentRoot==null){
            return null;
    }
    else{
        if(currentRoot.left==p || currentRoot.right==p)
            return currentRoot;
        else {
            if (currentRoot.element<p.element) {
                return parentHelper(currentRoot.right,p);
            }
            else {
                return parentHelper(currentRoot.left,p);
            }
        }
    }
}