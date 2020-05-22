{
     ....
     if (child != null) {
         for (Node c : child) {
            gChild = c.getChildren(); //Btw this is just dead store
            if (c.getId() == idChild) {
                return pParent; //You want to return the parent not the current node.
            } else {
                nParent = getParentNode(idChild, c);
                if (nParent != null) {
                    return nParent;
                }
            }
        }
    }  
    return null; //Node (idChild) not found in this subtree
}