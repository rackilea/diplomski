import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GraphTest {

  public static void main(String[] args) {
    UndirectedGraph<String, DefaultEdge> graph =
      new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

    String v1 = "v1";
    String v2 = "v2";
    String v3 = "v3";
    String v4 = "v4";

    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);

    graph.addEdge(v1, v2);
    graph.addEdge(v2, v3);
    graph.addEdge(v3, v4);
    graph.addEdge(v4, v1);

    if( graph.getEdge(v1, v2) != null) { System.out.println("SUCCESS"); }
    if (graph.getEdge(v2,v4) == null)  { System.out.println("SUCCESS"); }
  }
}