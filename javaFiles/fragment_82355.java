// after a short discussion, we found the solution
// return the size of HashSet known
public static int countVertices(Graph g, Graph.Vertex v) {
    Set<Graph.Vertex> known = new HashSet<>();
    int num = 0;

    if(g == null || v == null)
        return 0;

    // no loop, call DFS method and it will call itself recursively
    // and it will call the get neighbors()    
    if(!known.contains(v)) {
        num++;
        DFS(g, v, known);
    }
    return known.size();
}