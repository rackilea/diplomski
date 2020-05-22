Set<Object> edges = new HashSet();
for(Vertex v : orientGraph.getVertices()) {
    for( Edge e : v.getEdges( Direction.BOTH ) )
      edges.add( e.getIdentity() );
}
return edges.size();