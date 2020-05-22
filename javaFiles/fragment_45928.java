private static boolean dfs(Graph graph, Vertex root) {
    root.setBeingVisited(true);

    for (Edge edge : root.getNeighbors()) {
        Vertex neighborVertex = edge.getEndPoint();
        if (neighborVertex.isBeingVisited()) {
            return true;
        } else if (!neighborVertex.isVisited() && DFS.dfs(graph, neighborVertex)) {
            return true;
        }
    }

    root.setVisited(true);
    root.setBeingVisited(false);
    return false;
}