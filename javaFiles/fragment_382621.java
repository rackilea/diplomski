private Tree<String> CopyTree(Tree<String> tr){
if (tr == null)
    return null;
Tree<String> t = new Tree<String>();
t.setLabel(tr.getLabel());

Tree<String> temp = tr.left();

if (temp != null) {
    ArrayList<Tree<String>> list = new ArrayList<>();
    while (temp.getNextSibling() != null) {
    list.add(temp.getNextSibling());
    //t.addChild(CopyTree(temp.getNextSibling()));
    temp = temp.getNextSibling();
}
for (int i = (list.size()-1); i>=0; i--) {
    t.addChild(CopyTree(list.get(i)));
}

}
if (tr.left() != null) {
    t.addChild(CopyTree(tr.left()));
}

return t;
}