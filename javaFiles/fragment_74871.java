import java.util.*;

public class Graph {

    static class Edge {

        final char vA;
        final char vB;
        final double weight;

        Edge(char a, char b, double weight) {
            this.vA = a;
            this.vB = b;
            this.weight = weight;
        }

        @Override
        // compare if 2 edges are equal
        public boolean equals(Object obj) {
            if (obj instanceof Edge) {
                Edge other = (Edge) obj;
                return this.vA == other.vA && this.vB == other.vB;
            }
            return false;
        }

        @Override
        // string representation of edge
        public String toString() {
            return String.format("[%s -> %s] : %.2f", vA, vB, weight);
        }
    }

    // The edges could be stored directly in an ArrayList, but I assume
    // you'll need to lookup all edges for a give node.
    private Map<Character, ArrayList<Edge>> edges = new HashMap<>();

    void addNode(char node) {
        if (!edges.containsKey(node)) {
            edges.put(node, new ArrayList<Edge>());
        }
    }

    public void addEdge(char a, char b, double weight) {
        Edge edge = new Edge(a, b, weight);
        if (!edges.get(a).contains(edge)) {
            edges.get(a).add(edge);
        } else {
            System.out.printf("Edge [%s -> %s] already exists!%n", edge.vA, edge.vB);
        }
    }

    void printNodes() {
        System.out.printf("%nNODES:%n%s%n", edges.keySet());
    }

    void printEdges() {
        System.out.println("EDGES:");
        edges.forEach((node, edgeList) -> {
            /**
             * Take each pair <key,value> (here <Character, ArrayList<Edge>) from 
             * the HashMap 'edges' as variables (node,edgeList), where
             * node: represents the current node, e.g.: A
             * edgeList: contains all the edges starting from 'node', e.g. [[A,B,2],[A,C,3]]
             */
            System.out.printf("%s:%n", node); // print current node
            edgeList.forEach(edge -> {
                // take each Edge from the current ArrayList<Edge> edgeList as 'edge' and ...
                System.out.printf("  %s%n", edge); // print the edge value using Edge::toString()
            });
        });
    }


    void printEdgesFor() {
        // get all pairs of the HashMap as Entry:
        for (Map.Entry<Character, ArrayList<Edge>> entry : edges.entrySet()) {
            Character node = entry.getKey(); // Entry-key = node
            ArrayList<Edge> edgeList = entry.getValue(); // Entry-value = edgeList
            System.out.printf("%s:%n", node);
            for (Edge edge: edgeList) {
                System.out.printf("  %s%n", edge.toString());
            }
        }
    }

    void printEdgesFor2() {
        // get all keys:
        for (Character node: edges.keySet()) { // get all nodes (key from HashMap 'edges')
            ArrayList<Edge> edgeList = edges.get(node); // get edgeList from HashMap 'edges' using key
            System.out.printf("%s:%n", node);
            for (Edge edge: edgeList) { // with each edge of the current edgeList..
                System.out.printf("  %s%n", edge.toString()); // print
            }
        }
    }
}