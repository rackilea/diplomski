import java.util.*;

public class DijkstraAlgorithm {

    private static final Graph.Edge[] GRAPH = { 
        new Graph.Edge("A", "G", 8), 
        new Graph.Edge("A", "B", 1), 
        new Graph.Edge("A", "E", 1), 
        new Graph.Edge("B", "C", 1), 
        new Graph.Edge("B", "E", 1),
        new Graph.Edge("B", "F", 2),
        new Graph.Edge("C", "G", 1),
        new Graph.Edge("C", "D", 1),
        new Graph.Edge("D", "F", 1),
        new Graph.Edge("D", "Z", 1),
        new Graph.Edge("E", "F", 4),
        new Graph.Edge("F", "Z", 4),
        new Graph.Edge("G", "Z", 2),
    };

    private static final String START = "A";
    private static final String END = "Z";

    public static void main(String[] args) {
        Graph g = new Graph(GRAPH);
        g.dijkstra(START);
        g.restorePath(END);
        g.revertEdges(END);
        g.assignPotentials();
        g.dijkstra(START);
        g.restorePath(END);

        g.printPaths(START, END);
    }
}


class Graph {
    private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

    /** One edge of the graph (only used by Graph constructor) */
    public static class Edge implements Comparable<Edge> {
        public final String v1, v2;
        public final int dist;

        public Edge(String v1, String v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        public int compareTo(Edge other) {
            if (v1.equals(other.v1))
                return v2.compareTo(other.v2);
            return v1.compareTo(other.v1);
        }
    }

    private TreeSet<Edge> answer = new TreeSet<Edge>(); // stores all the edges in the answer

    /** One vertex of the graph, complete with mappings to neighbouring vertices */
    public static class Vertex implements Comparable<Vertex> {
        public final String name;
        public int potential = 0; // is assigned to dist before the second dijkstra
        public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<Vertex, Integer>();

        public Vertex(String name) {
            this.name = name;
        }

        public int compareTo(Vertex other) {
            if (dist==other.dist)
                return name.compareTo(other.name);
            return Integer.compare(dist, other.dist);
        }
    }

    /** Builds a graph from a set of edges */
    public Graph(Edge[] edges) {
        graph = new HashMap<String, Vertex>(edges.length);

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1))
                graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2))
                graph.put(e.v2, new Vertex(e.v2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
            graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<Vertex>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE)
                break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue() + u.potential - v.potential;
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void revertEdges(String endName) {
        Vertex v = graph.get(endName);
        while (v.previous != null && v.previous != v) {
            Vertex w = v.previous;
            int weight = v.neighbours.get(w);
            v.neighbours.remove(w);
            w.neighbours.remove(v);

            v.neighbours.put(w, - weight);

            v = w;
        }
    }

    public void assignPotentials() {
        for (Vertex v : graph.values()) {
            v.potential = v.dist;
        }
    }

    /** Stores the path found by dijkstra into the answer */
    public void restorePath(String endName) {
        Vertex v = graph.get(endName);
        while (v.previous != null && v.previous != v) {
            String from = v.previous.name;
            String to = v.name;
            if (answer.contains(new Edge(to, from, 0))) {
                answer.remove(new Edge(to, from, 0));
            }
            else {
                answer.add(new Edge(from, to, 0));
            }
            v = v.previous;
        }
    }

    /** Restores and prints one path based on `answer` dictionary, and removes the edges restored from the answer */
    public void printOnePath(String startName, String endName) {
        Vertex from = graph.get(startName);
        Vertex to = graph.get(endName);
        Vertex cur = from;
        do {
            System.out.printf("%s -> ", cur.name);

            Edge e = answer.ceiling(new Edge(cur.name, "", 0));
            answer.remove(e);

            cur = graph.get(e.v2);
        } while (cur != to);
        System.out.println(to.name);
    }

    /** Restores and prints paths based on `answer` dicrionary */
    public void printPaths(String startName, String endName) {
        printOnePath(startName, endName);
        printOnePath(startName, endName);
    }
}