import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

public class Test {

    public static void main(String[] args) {
        Frame testFrame = new Frame("Grafx-Test");
        testFrame.setAlwaysOnTop(true);
        Elypse elypse = new Elypse(new Point(70, 80), 30, 30, Color.BLUE, false);
        testFrame.add(elypse);
        Elypse elypse2 = new Elypse(new Point(70, 50), 50, 30, Color.BLUE, true);
        testFrame.add(elypse2);
        testFrame.pack();
        testFrame.setVisible(true);
    }

    private static class Elypse extends Canvas {

        private Point start;
        private int width;
        private int height;
        private Color c;
        private boolean filled;

        public Elypse(Point start, int width, int height, Color c, boolean filled) {
            this.start = start;
            this.width = width;
            this.height = height;
            this.c = c;
            this.filled = filled;
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(c);
            if (filled) {
                g.fillOval(start.x, start.y, width, height);
            } else {
                g.drawOval(start.x, start.y, width, height);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(320, 240);
        }
    }
}