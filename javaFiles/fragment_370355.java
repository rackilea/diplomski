import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;

public class JungVertexLabelColors 
{
    public static void main(String[] args) 
    {
        JFrame jf = new JFrame();
        final Graph<String, String> g = getGraph();
        final VisualizationViewer<String, String> vv = 
            new VisualizationViewer<String, String>(
                new FRLayout<String, String>(g));
        DefaultModalGraphMouse<Node, Double> graphMouse = 
            new DefaultModalGraphMouse<Node, Double>();
        vv.setGraphMouse(graphMouse); 


        final Color vertexLabelColor = Color.RED;
        DefaultVertexLabelRenderer vertexLabelRenderer = 
            new DefaultVertexLabelRenderer(vertexLabelColor)
        {
            @Override
            public <V> Component getVertexLabelRendererComponent(
                JComponent vv, Object value, Font font, 
                boolean isSelected, V vertex) 
            {
                super.getVertexLabelRendererComponent(
                    vv, value, font, isSelected, vertex);
                setForeground(vertexLabelColor);
                return this;
            }
        };
        vv.getRenderContext().setVertexLabelRenderer(vertexLabelRenderer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());



        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static Graph<String, String> getGraph() 
    {
        Graph<String, String> g = new DirectedSparseGraph<String, String>();
        g.addVertex("v0");
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addVertex("v4");
        g.addEdge("e0", "v0", "v1");
        g.addEdge("e1", "v1", "v2");
        g.addEdge("e2", "v2", "v3");
        g.addEdge("e3", "v3", "v4");
        g.addEdge("e4", "v4", "v0");
        g.addEdge("e5", "v1", "v3");
        g.addEdge("e6", "v2", "v4");
        return g;
    }    
}