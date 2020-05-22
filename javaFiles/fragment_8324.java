/** Print all the root nodes, each with any children it may have */
private void printRoots(List<Node> roots) {

    for (int j = 0; j < roots.size(); j++) {
        Node node = roots.get(j);
        printContents(node, 1);
    }

}

/** Print one node and any children it might have */
private void printContents(Node node, int level) {

    for (int i=1 ; i < level ; ++i) {
        print("    ");
    }
    print(node.toString());
    println();

    printChildren(node, level+1);

}

/** Print each child of the supplied node. Notice how this is just like getting the
 * list of children and calling 'printRoots()'
 *//
private void printChildren(Node node, int level) {

    for (int i = 0; i < node.getChildrenList().size(); i++) {
        Node childNode = node.getChildrenList().get(i);
        printContents(childNode, level);
    }

}