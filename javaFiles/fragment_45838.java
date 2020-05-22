Graph<V, E> src;
Graph<V, E> dest;

for (V v : src.getVertices())
    dest.addVertex(v);

for (E e : src.getEdges())
    dest.addEdge(e, src.getIncidentVertices(e));