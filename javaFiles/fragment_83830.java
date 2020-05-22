import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.MultiLayerTransformer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class JUNGEdgePathTest 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static BufferedImage createDummyImage()
    {
        int w = 100;
        int h = 30;
        BufferedImage image = 
            new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,w,h);
        g.setColor(Color.WHITE);
        g.drawString("Image", 10, 20);
        g.dispose();
        return image;
    }


    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        final Graph<String, String> graph = getGraph();
        final VisualizationViewer<String, String> vv = 
            new VisualizationViewer<String, String>(
                new FRLayout<String, String>(graph));
        final BufferedImage image = createDummyImage();

        String edge = graph.getEdges().iterator().next();
        final ImageAtEdgePainter<String, String> imageAtEdgePainter = 
            new ImageAtEdgePainter<String, String>(vv, edge, image);

        Timer t = new Timer(20, new ActionListener()
        {
            long prevMillis = 0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (prevMillis == 0)
                {
                    prevMillis = System.currentTimeMillis();
                }
                long dtMs = System.currentTimeMillis() - prevMillis;
                double dt = dtMs / 1000.0;
                double phase = 0.5 + Math.sin(dt) * 0.5;
                imageAtEdgePainter.setImageLocation(phase);
                vv.repaint();
            }
        });
        t.start();

        vv.addPostRenderPaintable(imageAtEdgePainter);


        f.getContentPane().add(vv);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    static class ImageAtEdgePainter<V, E> implements VisualizationViewer.Paintable
    {
        private final VisualizationViewer<V, E> vv;
        private final E edge;
        private final BufferedImage image;
        private double imageLocation;

        ImageAtEdgePainter(
            VisualizationViewer<V, E> vv, 
            E edge,
            BufferedImage image)
        {
            this.vv = vv;
            this.edge = edge;
            this.image = image;
        }

        public void setImageLocation(double imageLocation)
        {
            this.imageLocation = imageLocation;
        }

        @Override
        public void paint(Graphics gr)
        {
            Graphics2D g = (Graphics2D)gr;
            Shape shape = getTransformedEdgeShape(vv, vv.getGraphLayout(), edge);
            Point2D p = computePointAt(shape, 0.2, imageLocation);
            //g.setColor(Color.BLUE);
            //g.draw(shape);
            //System.out.println(p);
            gr.drawImage(image, (int)p.getX(), (int)p.getY(), null);
        }
        @Override
        public boolean useTransform()
        {
            return true;
        }

    }



    private static double computeLength(Shape shape, double flatness)
    {
        double length = 0;
        PathIterator pi = shape.getPathIterator(null, flatness);
        double[] coords = new double[6];
        double previous[] = new double[2];
        while (!pi.isDone())
        {
            int segment = pi.currentSegment(coords);
            switch (segment)
            {
                case PathIterator.SEG_MOVETO:
                    previous[0] = coords[0];
                    previous[1] = coords[1];
                    break;

                case PathIterator.SEG_LINETO:
                    double dx = previous[0]-coords[0];
                    double dy = previous[1]-coords[1];
                    length += Math.sqrt(dx*dx+dy*dy);
                    previous[0] = coords[0];
                    previous[1] = coords[1];
                    break;
            }
            pi.next();
        }
        return length;
    }

    public static Point2D computePointAt(
        Shape shape, double flatness, double alpha)
    {
        alpha = Math.min(1.0, Math.max(0.0, alpha));
        double totalLength = computeLength(shape, flatness);
        double targetLength = alpha * totalLength;
        double currentLength = 0;
        PathIterator pi = shape.getPathIterator(null, flatness);
        double[] coords = new double[6];
        double previous[] = new double[2];
        while (!pi.isDone())
        {
            int segment = pi.currentSegment(coords);
            switch (segment)
            {
                case PathIterator.SEG_MOVETO:
                    previous[0] = coords[0];
                    previous[1] = coords[1];
                    break;

                case PathIterator.SEG_LINETO:
                    double dx = previous[0]-coords[0];
                    double dy = previous[1]-coords[1];
                    double segmentLength = Math.sqrt(dx*dx+dy*dy);
                    double nextLength = currentLength + segmentLength;
                    if (nextLength >= targetLength)
                    {
                        double localAlpha = 
                            (currentLength - targetLength) / segmentLength;
                        //System.out.println("current "+currentLength+" target "+targetLength+" seg "+segmentLength);
                        double x = previous[0] + localAlpha * dx;
                        double y = previous[1] + localAlpha * dy;
                        return new Point2D.Double(x,y);
                    }
                    previous[0] = coords[0];
                    previous[1] = coords[1];
                    currentLength = nextLength;
                    break;
            }
            pi.next();
        }
        return null;
    }


    // This method is take from JUNG ShapePickSupport.java
    private static <V, E>  Shape getTransformedEdgeShape(
        VisualizationViewer<V, E> vv, Layout<V, E> layout, E e) {
        Pair<V> pair = layout.getGraph().getEndpoints(e);
        V v1 = pair.getFirst();
        V v2 = pair.getSecond();
        boolean isLoop = v1.equals(v2);
        RenderContext<V, E> rc = vv.getRenderContext();
        MultiLayerTransformer multiLayerTransformer = 
            rc.getMultiLayerTransformer();
        Point2D p1 = multiLayerTransformer.transform(
            Layer.LAYOUT, layout.transform(v1));
        Point2D p2 = multiLayerTransformer.transform(
            Layer.LAYOUT, layout.transform(v2));
        if(p1 == null || p2 == null) 
            return null;
        float x1 = (float) p1.getX();
        float y1 = (float) p1.getY();
        float x2 = (float) p2.getX();
        float y2 = (float) p2.getY();
        AffineTransform xform = AffineTransform.getTranslateInstance(x1, y1);
        Shape edgeShape = 
            rc.getEdgeShapeTransformer().transform(
                Context.<Graph<V,E>,E>getInstance(
                    vv.getGraphLayout().getGraph(),e));
        if(isLoop) {
            Shape s2 = rc.getVertexShapeTransformer().transform(v2);
            Rectangle2D s2Bounds = s2.getBounds2D();
            xform.scale(s2Bounds.getWidth(),s2Bounds.getHeight());
            xform.translate(0, -edgeShape.getBounds2D().getHeight()/2);
        } else {
            float dx = x2 - x1;
            float dy = y2 - y1;
            double theta = Math.atan2(dy,dx);
            xform.rotate(theta);
            float dist = (float) Math.sqrt(dx*dx + dy*dy);
            xform.scale(dist, 1.0f);
        }
        edgeShape = xform.createTransformedShape(edgeShape);
        return edgeShape;
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