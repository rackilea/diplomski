public String findPath(int v, int w) {
    Queue<Integer> q = new LinkedList<Integer>();
    boolean[] visited = new boolean[g.numVertices()];
    String[] pathTo = new String[g.numVertices()];

    q.add(v);
    pathTo[v] = v+" ";
    while(q.peek() != null) {
        if(runBFS(q.poll(),w,visited,q,pathTo))
        break;
    }
    return pathTo[w];
}

private boolean runBFS(int v, int w, boolean[] visited, Queue<Integer> q, String[] pathTo) {
    if(visited[v]) {
    }
    else if(v == w)
        return true; 
    }
    else {
        visited[v] = true;
        VertexIterator vi = g.adjacentVertices(v);
        while(vi.hasNext()) {
            int nextVertex = vi.next();
            pathTo[nextVertex] = pathTo[v] + nextVertex + " ";
            q.add(nextVertex);
        }
    }
    return false;
}