ModifiableConfiguration config = GraphDatabaseConfiguration.buildGraphConfiguration();
config.set(GraphDatabaseConfiguration.STORAGE_BACKEND, "berkeleyje");
config.set(GraphDatabaseConfiguration.STORAGE_DIRECTORY,"data");
TitanGraph graph = TitanFactory.open(config);

TitanManagement mgmt = graph.openManagement();
mgmt.makePropertyKey("name").dataType(String.class).make();
mgmt.makeEdgeLabel("friend").make();
mgmt.commit();

TitanTransaction tx = graph.newTransaction();
Vertex ashaful = tx.addVertex("name", "Ashraful Islam");
Vertex jishnu = tx.addVertex("name", "Jishnu Banerjee");
Vertex ovi = tx.addVertex("name", "Ahsanul Haque Ovi");
ashaful.addEdge("friend", jishnu);
jishnu.addEdge("friend", ovi);
tx.commit();

GraphTraversalSource g = graph.traversal();
GraphTraversal result = g.V().has("name", "Ashraful Islam").out("friend").out("friend").values("name");
while (result.hasNext()) {
    System.out.println(result.next());
}

graph.close();