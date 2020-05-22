public boolean isCyclicDirected(Vertex v){
  if (v.isVisited){
    return true;
  }

  v.setVisited(true);
  Iterator<Edge> e = v.adj.iterator();
  while (e.hasNext()) {
    Vertex t = e.next().target;

    // This while loop never goes beyond the first element.
    // you get the first vertex, then return from the
    // entire function.

    if (!t.isVisited && isCyclicDirected(t))
      return true;
    else return true;

  }
  return false;
}