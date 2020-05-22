parentList.forEach(p -> {
    childList
            .stream()
            .filter(matchesId(p))
            .<...continue working on stream...>
});

private Predicate<Node> matchesId(Node other) {
     return node -> node.id() == other.id();
}