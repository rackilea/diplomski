while (searchNodes.peek() != null) {
    String next = searchNodes.remove();
    boolean isNewNode = reachableNodes.add(next);
    if (isNewNode && graph.containsKey(next)) {
        for (String node : graph.get(next)) {
            searchNodes.add(node);
        }
    }
}