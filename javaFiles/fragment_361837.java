GRAPH.setNodeFactory(new NodeFactory<Node>() {
    @Override
    public Node newInstance(String id, Graph graph) {
        return new DataNode((AbstractGraph) graph, id);
    }
});