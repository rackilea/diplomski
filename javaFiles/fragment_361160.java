private static List<Node> getResourceNodes(Node node) {

    List<Node> matchedNodes = new ArrayList<>();

    if (node.isResource()) matchedNodes.add(node);

    for (Node child : node.getChildren()) {
        matchedNodes.addAll(getResourceNodes(child);
    }

    return matchedNodes;
}