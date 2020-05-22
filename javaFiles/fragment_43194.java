OrientGraph g = new OrientGraph("remote:localhost/yourDb");
 Vertex v1 = g.addVertex("class:YourClass");
 v1.setProperty("name", "foo");
 v1.setProperty("surname", "bar");
 Vertex v2 = g.addVertex("class:YourClass");
 v1.addEdge("YourEdgeClass", v2)
 g.shutdown();