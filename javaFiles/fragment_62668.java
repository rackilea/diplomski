public Node {
    public void search(List<Node> visitedList, Consumer<Node> action) {
        visitedList.add(this);
        linkedNodes.stream()
            .filter(n -> !visitedList.contains(n))
            .collect(Collectors.toList())
            .forEach(n -> n.search(visitedList, action);
        action.accept(this);
    }
}