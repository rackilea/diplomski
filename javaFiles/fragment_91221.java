Graph<Node, Edge> graph = new DirectedPseudograph<>(Edge.class);
Node bn1 = new Node("1", "A", null);
Node bn2 = new Node("2", "B", null);
Node bn3 = new Node("3", "C", null);

graph.addVertex(bn1);
graph.addVertex(bn2);
graph.addVertex(bn3);

Edge edge1 = new Edge("PART_OF");
Edge edge2 = new Edge("IS_A");
graph.addEdge(bn1, bn2, edge1);
graph.addEdge(bn3, bn2, edge2);

Graph<Node, Edge> undirGraph=new AsUndirectedGraph<>(graph);
ShortestPathAlgorithm<Node, Edge> shortestPath = new DijkstraShortestPath<Node, Edge>(undirGraph);