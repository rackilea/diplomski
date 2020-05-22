import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.JPanel;

public class WhatADag extends JApplet {

    @Override
    public void init() {
        add(new DragPane());
    }

    public class DragPane extends JPanel {

        private List<Box> boxes;

        public DragPane() {
            boxes = new ArrayList<>(25);
            boxes.add(new Box(0, 0, 50, 50, Color.RED));
            boxes.add(new Box(150, 150, 50, 50, Color.BLUE));

            MouseAdapter handler = new MouseAdapter() {

                private Box hitBox;
                private Point offset;

                @Override
                public void mousePressed(MouseEvent e) {
                    Point mp = e.getPoint();
                    for (Box box : boxes) {
                        if (box.getBounds().contains(mp)) {
                            hitBox = box;

                            offset = new Point();
                            offset.x = mp.x - box.getBounds().x;
                            offset.y = mp.y - box.getBounds().y;
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    hitBox = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (hitBox != null) {
                        Point mp = e.getPoint();
                        Rectangle bounds = hitBox.getBounds();
                        bounds.x = mp.x - offset.x;
                        bounds.y = mp.y - offset.y;
                        repaint();
                    }
                }

            };

            addMouseListener(handler);
            addMouseMotionListener(handler);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Box rect : boxes) {
                g2d.setColor(rect.getColor());
                g2d.fill(rect.getBounds());
            }
            g2d.dispose();
        }

    }

    public class Box {

        private Color color;
        private Rectangle rectangle;

        public Box(int x, int y, int width, int height, Color color) {
            rectangle = new Rectangle(x, y, width, height);
            setColor(color);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public Rectangle getBounds() {
            return rectangle;
        }

    }

}