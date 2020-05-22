public void  allResturants (){
    final QueryResult<Map<String,Object>> result = engine.query("...", null);
     for (Map<String, Object> row : result) {
        Node node = (Node) map.get("n"); // org.neo4j.graphdb.Node
        System.out.println("name is " + node.getProperty("name"));
     }
}