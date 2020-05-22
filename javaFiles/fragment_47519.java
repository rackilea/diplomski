import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyShapes extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private JMenuBar menuBar = new JMenuBar();
    private Color color = null;
    public DrawShape drawShape = null;

    public MyShapes() {
        // create and fill colorMenu
        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(new JMenuItem(new ColorAction("Black", Color.BLACK)));
        colorMenu.add(new JMenuItem(new ColorAction("White", Color.WHITE)));
        colorMenu.add(new JMenuItem(new ColorAction("Red", Color.RED)));
        colorMenu.add(new JMenuItem(new ColorAction("Blue", Color.BLUE)));
        colorMenu.add(new JMenuItem(new ColorAction("Green", Color.GREEN)));

        // create and fill shapeMenu
        JMenu shapeMenu = new JMenu("Shape");
        shapeMenu.add(new JMenuItem(new DrawShapeAction("Square", new DrawShape() {

            @Override
            public void draw(Graphics g) {
                int x = getWidth() / 4;
                int y = getHeight() / 4;
                int width = getWidth() / 2;
                int height = getHeight() / 2;
                g.fillRect(x, y, width, height);
            }
        })));
        shapeMenu.add(new JMenuItem(new DrawShapeAction("Circle", new DrawShape() {

            @Override
            public void draw(Graphics g) {
                int x = getWidth() / 4;
                int y = getHeight() / 4;
                int width = getWidth() / 2;
                int height = getHeight() / 2;
                g.fillOval(x, y, width, height);
            }
        })));
        shapeMenu.add(new JMenuItem(new DrawShapeAction("Triangle", new DrawShape() {

            @Override
            public void draw(Graphics g) {
                int[] x = new int[3];
                int[] y = new int[3];
                x[0] = getWidth() / 4;
                x[1] = getWidth() / 2;
                x[2] = 3 * getWidth() / 4;
                y[0] = 3 * getHeight() / 4;
                y[1] = getHeight() / 4;
                y[2] = y[0];
                Polygon polygon = new Polygon(x, y, 3);
                g.fillPolygon(polygon);
            }
        })));

        // add both JMenus to the JMenuBar
        menuBar.add(colorMenu);
        menuBar.add(shapeMenu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // if either color or drawShape are not set, exit this method and draw nothing
        if (color == null || drawShape == null) {
            return;
        }

        // to smooth out the edges
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // set color and call drawShape's draw method
        g.setColor(color);
        drawShape.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private class ColorAction extends AbstractAction {
        private Color actionColor;

        public ColorAction(String name, Color color) {
            super(name);
            this.actionColor = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MyShapes.this.color = actionColor;
            repaint();
        }
    }

    private class DrawShapeAction extends AbstractAction {
        private DrawShape actionDrawShape;

        public DrawShapeAction(String name, DrawShape drawShape) {
            super(name);
            this.actionDrawShape = drawShape;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MyShapes.this.drawShape = actionDrawShape;
            repaint();
        }
    }

    private interface DrawShape {
        void draw(Graphics g);
    }

    private static void createAndShowGui() {
        MyShapes mainPanel = new MyShapes();

        JFrame frame = new JFrame("MyShapes");
        frame.setJMenuBar(mainPanel.getMenuBar());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}