import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawChit extends JPanel {
    private static final int PREF_W = 900;
    private static final int PREF_H = 700;
    private static final int MAX_SHAPES = 30;
    private List<MyShape> shapes = new ArrayList<>();

    public DrawChit() {
        setBackground(Color.WHITE);

        for (int i = 0; i < MAX_SHAPES; i++) {
            double x = (PREF_W - 100) * Math.random();
            double y = (PREF_H - 100) * Math.random();
            double w = 100 + (Math.random() * PREF_W) / 10;
            double h = 100 + (Math.random() * PREF_H) / 10;
            Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);

            float hue = (float) Math.random();
            double delta = 0.3;
            float saturation = (float) (Math.random() * delta + (1 - delta));
            float brightness = (float) (Math.random() * delta + (1 - delta));
            Color color = Color.getHSBColor(hue, saturation, brightness);
            shapes.add(new MyShape(ellipse, color));
        }

        // we'll throw a black square in the middle!
        int rectW = 200;
        int rectX = (PREF_W - rectW) / 2;
        int rectY = (PREF_H - rectW) / 2;
        shapes.add(new MyShape(new Rectangle(rectX, rectY, rectW, rectW), Color.BLACK));

        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // use anti-aliasing to make graphics smooth
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // iterate through the shapes list, filling all 
        for (MyShape shape : shapes) {
            shape.fill(g2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {
        private Point p0 = null;
        private MyShape shape = null;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }

            // iterate *backwards* so get top-most Shape
            for (int i = shapes.size() - 1; i >= 0; i--) {
                if (shapes.get(i).contains(e.getPoint())) {
                    p0 = e.getPoint();
                    shape = shapes.get(i);

                    // move selected shape to the top!
                    shapes.remove(shape);
                    shapes.add(shape);

                    repaint();
                    return;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (p0 != null) {
                moveShape(e.getPoint());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (p0 != null) {
                moveShape(e.getPoint());
                p0 = null;
                shape = null;
            }
        }

        // translates the shape 
        private void moveShape(Point p1) {
            int deltaX = p1.x - p0.x;
            int deltaY = p1.y - p0.y;
            shape.translate(deltaX, deltaY);
            p0 = p1;
            repaint();
        }
    }

    private static void createAndShowGui() {
        DrawChit mainPanel = new DrawChit();

        JFrame frame = new JFrame("Draw Chit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}