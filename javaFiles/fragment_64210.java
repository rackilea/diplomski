for (Edge edge : common) {
        Node node1 = edge.getNode0();
        Node node2 = edge.getNode1();
        graph.addEdge(edge.getId(), node1, node2, false);   <--- Replace it with
        graph.addEdge(edge.getId(), node_1, node_2, false);
        changeEdge.add(graph.getEdge(edge.getId()));
}