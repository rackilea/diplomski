import com.google.common.base.Function;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import javax.swing.*;
import java.awt.*;


public class GraphView {

     public GraphView() {

        GraphBuilding gb = new GraphBuilding(); // This builds the graph

        // Layout<V, E>, BasicVisualizationServer<V,E>
        Layout<String, String> layout = new CircleLayout(gb.g);

        layout.setSize(new Dimension(300, 300));
        BasicVisualizationServer<String, String> vv =
            new BasicVisualizationServer<String, String>(layout);
        vv.setPreferredSize(new Dimension(350, 350));

        // Setup up a new vertex to paint transformer...
        Function<String, Paint> vertexPaint = new Function<String, Paint>() {
                public Paint apply(String i) {
                return Color.GREEN;
            }
        };

        // Set up a new stroke Transformer for the edges
        float dash[] = {10.0f};
        final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        Function<String, Stroke> edgeStrokeTransformer =
            new Function<String, Stroke>() {
                public Stroke apply(String s) {
                    return edgeStroke;
                }
            };

        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderer().getVertexLabelRenderer()
             .setPosition(Renderer.VertexLabel.Position.CNTR);

        JFrame frame = new JFrame("Custom Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}