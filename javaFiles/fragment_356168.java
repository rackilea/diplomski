import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.renderers.CenterEdgeArrowRenderingSupport;
import edu.uci.ics.jung.visualization.renderers.Renderer;

public class JUNGEdgeCenterArrows 
{
    public static void main(String[] args) 
    {
        JFrame f = new JFrame();
        final Graph<String, String> g = getGraph();
        VisualizationViewer<String, String> vv = 
            new VisualizationViewer<String, String>(
                new FRLayout<String, String>(g));
        Renderer.Edge<String, String> edgeRenderer = 
            vv.getRenderer().getEdgeRenderer();
        edgeRenderer.setEdgeArrowRenderingSupport(
            new CenterEdgeArrowRenderingSupport<String, String>());
        f.getContentPane().add(vv);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }


    public static Graph<String, String> getGraph() 
    {
        Graph<String, String> g = 
            new DirectedSparseMultigraph<String, String>();
        g.addVertex("v0");
        g.addVertex("v1");
        g.addEdge("e0", "v0", "v1");
        g.addEdge("e1", "v0", "v1");
        g.addEdge("e2", "v0", "v1");
        return g;
    }
}