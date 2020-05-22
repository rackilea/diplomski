public void shortestPath(Vertex startVertex) {
    startVertex.setMinDistance(0);
    PriorityQueue<Vertex> queue = new PriorityQueue<>();
    queue.add(startVertex);
    //The rest is omitted
}