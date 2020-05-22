public void printTree(Node root, int tabLevel, PrintStream out){
    for(int i =0;i < tabLevel; i++) out.print("\t");
    out.println(root)
    for(Node n: root.getChildren())
        printTree(n, tabLevel + 1, out);
}