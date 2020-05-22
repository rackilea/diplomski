class Edge {
// represents edge with destination node and it's weight
        private final Node node;
        private final int weight;

        Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

// represents map which holds all outgoing edges keyed by source nodes.
    Map<Node, Set<Edges>> edgesByOutgoingNodes = new HashMap<Node, Set<Edges>>();