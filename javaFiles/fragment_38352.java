Map<Integer, List<GraphEdge>> edgesByPolygon = new HashMap<>();
for (GraphEdge edge : edgesList) {
    List<GraphEdge> list = edgesByPolygon.get(edge.site1);
    if (list == null) {
        list = new ArrayList<>();
        edgesByPolygon.put(edge.site1, list);
    }
    list.add(edge);

    list = edgesByPolygon.get(edge.site2);
    if (list == null) {
        list = new ArrayList<>();
        edgesByPolygon.put(edge.site2, list);
    }
    list.add(edge);
}

for (List<GraphEdge> list : edgesByPolygon.valueSet()) {
    // order the edges by adjacency and construct the polygon instance
    // (a naive algorithm will do, as the average number of edges is small)
}