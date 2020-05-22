public void getSuccessor(DirectedGraph<Point, DefaultEdge> graph, Point point, String type, int depth) {
    List<Point> visitedPoints = new ArrayList<>();
    _getSuccessor(graph, point, visitedPoints, type, depth);
}

private void _getSuccessor(DirectedGraph<Point, DefaultEdge> graph, Point point, List<Point> visitedPoints, String type, int depth){

    if(depth == 0)
        return;

    // Mark node as visited
    visitedPoints.add(point);

    // Loop on all its successors
    for(Point successor : Graphs.successorListOf (directedGraph, point)){

        // If node not already visited
        if(!visitedPoints.contains(successor) && successor.type.equals(type)) {
            directedGraph.addEdge(firstPoint, successor);
            _getSuccessor(graph, successor, visitedPoints, type, depth-1);
        }
    }
}