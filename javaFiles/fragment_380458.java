private boolean bfs(Vertex source, Vertex destination, List<Edge> path) {
    Queue<Vertex> queue = new LinkedList<Vertex>();
    List<Vertex> visited = new ArrayList<Vertex>(); // list of visited vertexes
    queue.add(source);
    visited.add(source);
    Map<Vertex, Edge> predecessorEdges = new HashMap<Vertex, Edge>();
    while(!queue.isEmpty()) {
        Vertex d = queue.remove();
        if(!d.equals(destination)) {
            ArrayList<Edge> d_outgoingEdges = outgoingEdges.get(d);
            for(Edge e : d_outgoingEdges) {
                if(e.getCapacity() - e.getFlow() > 0) { // there is still available flow
                    Vertex u = e.getDestination();
                    if(!visited.contains(u)) {
                        visited.add(u);
                        queue.add(u);
                        predecessorEdges.put(u, e);
                    }
                }
            }
        }
        else
        {
            constructPath(destination, predecessorEdges, path);
            return true;
        }
    }
    return false;
}

private void constructPath(Vertex destination,
    Map<Vertex, Edge> predecessorEdges, List<Edge> path)
{
    Vertex v = destination;
    while (true)
    {
        Edge e = predecessorEdges.get(v);
        if (e == null)
        {
            return;
        }
        path.add(0, e);
        v = e.getSource();
    }
}