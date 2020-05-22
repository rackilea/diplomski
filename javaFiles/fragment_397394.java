Iterator<Edge> eIt = edges.iterator();
 while(eIt.hasNext()){
    Edge e = eIt.next();
    mainGraph.addEdge(e, e.getNode1(), e.getNode2()); // actually, you can change
                                                      // addEdge to require just
                                                      // the Edge, since it already
                                                      // contains the Nodes
}