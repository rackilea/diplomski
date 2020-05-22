private nNode recursiveSearch(data gi,nNode node){
    if (node.getdata()==gi)
        return node;
    nNode[] children = node.getChildren(); 
    nNode res = null;
    for (int i = 0; res == null && i < children.length; i++) {         
        res = recursiveSearch(gi, children[i]);
    }
    return res;
 }