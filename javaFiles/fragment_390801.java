public class FindNode {

    @Context
    public GraphDatabaseService db;

    @Context
    public Log log;


    @Procedure(value = "boris.getAllNodesWithProperty", mode = Mode.READ)
    @Description("boris.getAllNodesWithProperty - finds Node by ID and return defined Property")
    public Stream<NodeResult> passName(@Name("nodeId") long nodeId)

    {
        Node node = db.getNodeById( nodeId );
        Object nameVal = node.getProperty("name");
        Label label = Label.label("VersionableObject");

        ResourceIterator<Node> nodes = db.findNodes(label, "name", nameVal);

        return nodes.stream().map( item -> new NodeResult(item));
    }

    public class NodeResult {

        public final Node node;

        public NodeResult(Node node) {
            this.node = node;
        }
    }


}