public int traverse(Node n){
    int numOfLeaves = 0;
    for (int i=0; i<n.getNumEdges(); i++) {
        if(n.getEdgeChar(i) == '#') { // leaf
            numOfLeaves += 1;
        }
        else {
            numOfLeaves += traverse((n.getEdge(i)).getNode());
        }
    }
    return numOfLeaves;
}