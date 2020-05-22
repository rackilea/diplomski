@QueryResult
public class NodeWithLabel {
    Long id;
    Map<String,Object> node;
    ArrayList<String> labels;
}


@Query("MATCH (n:GLNode) RETURN ID(n) as id, labels(n) as labels, {properties : n} as node")
Collection<NodeWithLabel> getAllNodesWithLabel();