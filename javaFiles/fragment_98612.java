public class TestNeo4j {

    public static void main(String[] args) throws Exception {
        final GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("db");
        final Transaction tx = graphDb.beginTx();
        final Node node = graphDb.createNode();
        node.setProperty("test", "test");
        tx.success();
        tx.close();
        final ExecutionEngine engine = new ExecutionEngine(graphDb);
        System.out.println(engine.execute("START n=node(*) RETURN id(n), n.test").dumpToString());
        graphDb.shutdown();
    }

}