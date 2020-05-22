private int pathCount = 0;

// more of you code ...

private void DFS(GraphPath1 graph, LinkedList<String> visited) {
    LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
    // examine adjacent nodes
    for (String node : nodes) {
        if (visited.contains(node)) {
            continue;
        }
        if (node.equals(END)) {
            visited.add(node);
            pathNumber++;
            System.out.println("This is path " + pathNumber + ":");
            printPath(visited);
            visited.removeLast();
            break;
        }
    }

    // the rest of the algorithm ...
}