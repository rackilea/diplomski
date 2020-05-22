import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.HopcroftKarpBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GraphDemo {

    public static void main(String[] args) {
        UndirectedGraph<String, DefaultEdge> g = 
                new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        String x1 = "x1";
        String x2 = "x2";
        String x3 = "x3";

        String y1 = "y1";
        String y2 = "y2";
        String y3 = "y3";
        String y4 = "y5";

        g.addVertex(x1);
        g.addVertex(x2);
        g.addVertex(x3);

        g.addVertex(y1);
        g.addVertex(y2);
        g.addVertex(y3);
        g.addVertex(y4);

        g.addEdge(x1, y1);
        g.addEdge(x1, y2);

        g.addEdge(x2, y1);
        g.addEdge(x2, y4);

        g.addEdge(x3, y2);
        g.addEdge(x3, y3);

        Set<String> p1 = new HashSet<String>(Arrays.asList(x1, x2, x3));
        Set<String> p2 = new HashSet<String>(Arrays.asList(y1, y2, y3, y4));

        HopcroftKarpBipartiteMatching<String, DefaultEdge> alg = 
            new HopcroftKarpBipartiteMatching<String, DefaultEdge>(g, p1, p2);

        Set<DefaultEdge> match = alg.getMatching();

        System.out.println(g.toString());
        System.out.println(match);
    }
}