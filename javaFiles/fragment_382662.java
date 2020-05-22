@Override
public String toString(){
        StringBuilder buffer = new StringBuilder();
        printTree(this, buffer);
        return buffer.toString();
}

public void printTree(AbstractTree<E> tree, StringBuilder buffer){
    if (tree.isLeaf()){
        buffer.append(tree.getNodeName());
    } else {
        buffer.append(tree.getNodeName());
        buffer.append("(");

        int i = 0;
        Iterator<AbstractTree<E>> child = tree.getChildren().iterator();
        while (i < tree.getChildren().size() - 1){
            printTree(child.next(), buffer);
            buffer.append(", ");
            i++;
        }
        printTree(child.next(), buffer); 
        buffer.append(")");
    }
}