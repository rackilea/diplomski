import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class Design {

    public Graph<Integer, String> g;
    public Design() {     

         this.g = readNet("SmallTown.net");
    }

    private static class VertexPaintTransformer implements Transformer<Integer,Paint> {

        private final PickedInfo<Integer> pi;

        VertexPaintTransformer ( PickedInfo<Integer> pi ) { 
            super();
            if (pi == null)
                throw new IllegalArgumentException("PickedInfo instance must be non-null");
            this.pi = pi;
        }

        @Override
        public Paint transform(Integer i) {
            Color p = null;
            if ( i % 2 == 0)
                p = Color.GREEN;
            else
                p =  Color.RED;

            if ( pi.isPicked(i)){
                p = Color.yellow;
            }
            return p;
        }
    }

    private static class VertexLabelTransformer implements Transformer<Integer,String>{
        private final PickedInfo<Integer> pi;

        public VertexLabelTransformer( PickedInfo<Integer> pi ){
            this.pi = pi;
        }

        @Override
        public String transform(Integer t) {
            if (pi.isPicked(t))
                return t.toString();
            else
              return "";
        }
    }


    @SuppressWarnings("unchecked")
    public static <Paint> void main(String[] args) {
        Design sgv = new Design(); 
        Layout<Integer, String> layout = new FRLayout(sgv.g);
        layout.setSize(new Dimension(800,800));  
        VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(layout);

        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {

            @Override
            public Paint transform(Integer i) {
                if ( i % 2 == 0)
                    return (Paint) Color.GREEN;
                else
                    return  (Paint) Color.RED;
            }
        };  

        vv.setPreferredSize(new Dimension(850,850));
        vv.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.green));
        vv.getRenderContext().setVertexLabelTransformer(new VertexLabelTransformer(vv.getPickedVertexState()));


        vv.getRenderContext().setEdgeDrawPaintTransformer(new ConstantTransformer(Color.white));
        vv.getRenderContext().setEdgeStrokeTransformer(new ConstantTransformer(new BasicStroke(2.5f)));

        vv.getRenderContext().setVertexFillPaintTransformer(new VertexPaintTransformer(vv.getPickedVertexState()));

        DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
        graphMouse.setMode(edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode.PICKING);
        vv.setGraphMouse(graphMouse);

        vv.setBackground(Color.gray);

        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);


        JFrame frame = new JFrame("Projet Algo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); 
        frame.pack();
        frame.setVisible(true);       
    }

    public static Graph<Integer, String> readNet(String string) {
        // Graph<V, E> where V is the type of the vertices
        // and E is the type of the edges
        Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
        // Add some vertices. From above we defined these to be type Integer.
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        // Add some edges. From above we defined these to be of type String
        // Note that the default is for undirected edges.
        g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
        g.addEdge("Edge-B", 2, 3);
        // Let's see what we have. Note the nice output from the
        // SparseMultigraph<V,E> toString() method
        System.out.println("The graph g = " + g.toString());
        // Note that we can use the same nodes and edges in two different graphs.
        Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
        g2.addVertex(1);
        g2.addVertex(2);
        g2.addVertex(3);
        g2.addEdge("Edge-A", 1,3);
        g2.addEdge("Edge-B", 2,3, EdgeType.DIRECTED);
        g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        g2.addEdge("Edge-P", 2,3); // A parallel edge
        return  g2;

    }
}