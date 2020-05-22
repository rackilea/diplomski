public DefaultMutableTreeNode findparentnode(String s,DefaultMutableTreeNode root){
    DefaultMutableTreeNode parent=null;
    for (int i=0;i<root.getChildCount();i++) {
        if(s.equalsIgnoreCase(((DefaultMutableTreeNode)root.getChildAt(i)).toString())){
             parent = (DefaultMutableTreeNode)root.getChildAt(i);
            break;
        }
        else
            parent=findparentnode(s, (DefaultMutableTreeNode)root.getChildAt(i));
    }
    return parent;
}