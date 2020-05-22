import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

/**
 * @see http://stackoverflow.com/a/37193636/230513
 */
public class MapWorkerTest {

    private final List<Coordinate> route = new ArrayList<>();

    private void display() {
        JFrame f = new JFrame("MapWorker");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMapViewer map = new JMapViewer() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }

            @Override
            public String getToolTipText(MouseEvent e) {
                Coordinate c = (Coordinate) getPosition(e.getX(), e.getY());
                return c.getLat() + " " + c.getLon();
            }
        };
        map.setToolTipText("");
        Coordinate start = new Coordinate(-34.9286, 138.6);
        route.add(start);
        MapPolygonImpl poly = new MapPolygonImpl(route);
        poly.setColor(Color.blue);
        map.addMapPolygon(poly);
        map.setDisplayPosition(start, 10);
        f.add(map);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        new MapWorker(map, start).execute();
    }

    private class MapWorker extends SwingWorker<Void, Coordinate> {

        private final JMapViewer map;
        private Coordinate last;

        public MapWorker(JMapViewer map, Coordinate start) {
            this.map = map;
            this.last = start;
        }

        @Override
        protected Void doInBackground() throws Exception {
            while (!isCancelled()) {
                last = new Coordinate(last.getLat() + 0.0025, last.getLon() + 0.01);
                publish(last);
                Thread.sleep(1000);
            }
            return null;
        }

        @Override
        protected void process(List<Coordinate> chunks) {
            for (Coordinate c : chunks) {
                route.add(c);
            }
            map.repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new MapWorkerTest()::display);
    }
}