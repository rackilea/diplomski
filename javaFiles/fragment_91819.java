public void printPaths(Node<T> nodeOnPath, String onPath){
    String nodePath = onPath + "/" + nodeOnPath.getNodeContent().toString(); 
    if (nodeOnPath.isLeaf()){
        System.out.println(nodePath);
        return; 
    }

    ArrayList<Node> children = nodeOnPath.getChildren(); 
    for (Node<T> node : children){
        printPaths(node, nodePath); 
    }
}