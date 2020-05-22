import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Graph Editor");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.add(new MyPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public class Coordinate {

        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public class Icon {

        private Coordinate coordinate;

        public Icon(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(0, 0, 20, 20);
        }
    }

    public class MyPanel extends JPanel {

        private Set<Icon> points;

        public MyPanel() {
            points = new HashSet<>();
            setLayout(null);
            setPreferredSize(new Dimension(600, 600));
            setBackground(Color.YELLOW);
        }

        //gets called by `FILE OPEN` listener for each coordinate
        public void makeIcons(Coordinate obj) {
            points.add(new Icon(obj));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            for (Icon icon : points) {
                Graphics2D g2d = (Graphics2D) g.create();
                Coordinate coordinate = icon.getCoordinate();
                // I'd have a size component associated with the Icon
                // which I'd then use to offset the context by half its
                // value, so the icon is paint around the center of the point
                g2d.translate(coordinate.getX() - 10, coordinate.getY() - 10);
                icon.paint(g2d);
                g2d.dispose();
            }
        }

    }
}