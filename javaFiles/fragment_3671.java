List<Node> nodes = new ArrayList<>();
Map<Node, RawNode> rawNodesByNode = new HashMap<>();
Map<Integer, Node> nodesById = new HashMap<>();
for(RawNode rawNode : tmpList) {
    Node node = new Node();
    node.setId(rawNode.getId());
    node.setText(rawNode.getText());
    rawNodesByNode.put(node, rawNode);
    nodesById.put(rawNode.getId(), node);
}