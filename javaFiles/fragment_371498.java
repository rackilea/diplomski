import java.awt.Dimension;
import javax.swing.JFrame;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.layout.graph.ForceDirectedLayout;
import prefuse.activity.Activity;
import prefuse.controls.DragControl;
import prefuse.controls.PanControl;
import prefuse.controls.ZoomControl;
import prefuse.data.Graph;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.LabelRenderer;
import prefuse.util.ColorLib;
import prefuse.util.GraphLib;
import prefuse.visual.VisualItem;

/** @see https://stackoverflow.com/a/44274886/230513 */
public class Example {

    private static final int W = 640;
    private static final int H = 480;

    public static void main(String[] argv) {

        // -- 1. create the data ------------------------------------------------
        Graph graph = GraphLib.getDiamondTree(3, 2, 1);

        // -- 2. the visualization --------------------------------------------
        // add the graph to the visualization as the data group "graph"
        // nodes and edges are accessible as "graph.nodes" and "graph.edges"
        Visualization vis = new Visualization();
        vis.add("graph", graph);
        vis.setInteractive("graph.edges", null, false);

        // -- 3. the renderers and renderer factory ---------------------------
        LabelRenderer r = new LabelRenderer(GraphLib.LABEL);
        r.setRoundedCorner(8, 8); // round the corners

        // create a new default renderer factory
        // return our name label renderer as the default for all non-EdgeItems
        // includes straight line edges for EdgeItems by default
        vis.setRendererFactory(new DefaultRendererFactory(r));

        // -- 4. the processing actions ---------------------------------------
        ColorAction fill = new ColorAction("graph.nodes",
            VisualItem.FILLCOLOR, ColorLib.rgb(200, 200, 255));
        // use black for node text
        ColorAction text = new ColorAction("graph.nodes",
            VisualItem.TEXTCOLOR, ColorLib.gray(0));
        // use light grey for edges
        ColorAction edges = new ColorAction("graph.edges",
            VisualItem.STROKECOLOR, ColorLib.gray(200));

        // create an action list containing all color assignments
        ActionList color = new ActionList();
        color.add(fill);
        color.add(text);
        color.add(edges);

        // create an action list with an animated layout
        ActionList layout = new ActionList(Activity.INFINITY);
        layout.add(new ForceDirectedLayout("graph"));
        layout.add(new RepaintAction());

        // add the actions to the visualization
        vis.putAction("color", color);
        vis.putAction("layout", layout);

        // -- 5. the display and interactive controls -------------------------
        Display d = new Display(vis) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(W, H);
            }
        };
        d.setSize(W, H); // set display size
        d.pan(W / 2, H / 2); // pan to center
        d.addControlListener(new DragControl());
        d.addControlListener(new PanControl());
        d.addControlListener(new ZoomControl());

        // -- 6. launch the visualization -------------------------------------
        JFrame frame = new JFrame("prefuse label example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(d);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // show the window

        vis.run("color");
        vis.run("layout");
    }
}