public void computeDijkstras(DijkstraNode startNode, List<DijkstraNode> nodes) {
    Map<DijkstraNode, Integer> distances = new HashMap<DijkstraNode, Integer>();
    for (DijkstraNode node : nodes) {
        if (node != startNode) {
            distances.put(node, Integer.MAX_VALUE);
        }
        else {
            distances.put(node, 0);
        }
    }

    List<DijkstraNode> computedNodes = new ArrayList<DijkstraNode>();

    DijkstraNode toEval = computeSmallestUncomputedNode(distances, computedNodes); // TODO

    while (toEval != null) {
        for (DijkstraLink link : toEval.getLinks()) {
            if (computedNodes.contains(link.getLinkedNode()) {
                continue;
            }
            int evalDist = link.getDistance() + distances.get(toEval);
            if (evalDist < distances.get(link.getLinkedNode())) {
                distances.put(link.getLinkedNode(), evalDist);
            }
        }

        computedNodes.add(toEval);

        toEval = computeSmallestUncomputedNode(distances, computedNodes);
    }

    // distances computed; do whatever.
}