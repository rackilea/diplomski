private static Stream<TerminalNode> flatten(final List<Node> nodes) {
    return nodes
            .stream()
            .flatMap(node -> {
                if (node instanceof InternalNode) {
                    return flatten(((InternalNode) node).getNodes());
                }
                return Stream.of((TerminalNode) node);
            });
}