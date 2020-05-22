private void printTree(Node t){
    if(t != null){
        System.out.print("(");
        printTree(t.left);
        System.out.print(t.element + " ")
        printTree(t.right);
        System.out.print(")");
    }
}