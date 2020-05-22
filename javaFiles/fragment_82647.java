/**
 * @author Christian Bongiorno
 */
public class Graph {

    private class Vertex {
        Map<String,Object> properties;
        private Map<String,Edge> edges;

        public Graph addVertex(String edgeName, Vertex v) {
            Edge e = edges.get(edgeName);
            if(e == null) {
                e = new Edge(this);
                edges.put(edgeName,e);
            }

            e.addVertex(v);
            return Graph.this;
        }

        public Graph addVertex(Vertex v) {
            return addVertex("anonymous",v);
        }

    }

    private static class Edge {
        Map<String,Object> properties;
        Vertex in;
        Collection<Vertex> out;

        private Edge(Vertex in) {
            this.in = in;
        }


        private void addVertex(Vertex v) {
            out.add(v);
        }
    }

}