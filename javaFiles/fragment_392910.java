class PathFinder {
    Path shortestPath;
    public void findShortestPath(Path currentPath, List<Node> remainingNodes) {
        if (remainingNodes.isEmpty()) {
            if (currentPath.isShorterThan(shortestPath)) {
                shortestPath = currentPath;
            }
        } else {
            for (Node node: currentPath.possibleNextNodes(remainingNodes)) {
                remainingNodes.remove(node);
                currentPath.add(node);
                findShortestPath(currentPath, remainingNodes);
                currentPath.remove(node);
                remainingNodes.add(node);
            }
        }
    }
}