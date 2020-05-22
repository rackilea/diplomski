public boolean isCyclicDirected(Vertex v){
  if (v.isVisited){
    return true;
  }
  v.setVisited(true);
  Iterator<Edge> e = v.adj.iterator();
  while (e.hasNext()) {
    Vertex t = e.next().target;
    // quick test:
    if (t.isVisited) {
      return true;
    }
    // elaborate, recursive test:
    if(isCyclicDirected(t)) {
      return true;
    }
  }
  // none of our adjacent vertices flag as cyclic
  return false;
}