HashMap<Pair<Vertex, Vertex>, Edge> vertexMap = new HashMap<>();

for (Edge e : edges) {
    Pair<Vertex, Vertex> key = new Pair<>(e.v1, e.v2);
    vertexMap.put(key, e);
}