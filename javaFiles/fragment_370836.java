import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class AffineTransformTest {

    private static TransformingCanvas canvas;

    public static void main(String[] args) {
        TransformingCanvas.initializePointList();
        JFrame frame = new JFrame();
        canvas = new TransformingCanvas(TransformingCanvas.POINT_LIST);
        JDesktopPane desktop = new JDesktopPane();
        TranslateHandler translator = new TranslateHandler();
        canvas.addMouseListener(translator);
        canvas.addMouseMotionListener(translator);
        canvas.addMouseWheelListener(new ScaleHandler());
        MyInternalFrame iFrame = new MyInternalFrame();
        iFrame.setLayout(new BorderLayout());
        iFrame.add(canvas, BorderLayout.CENTER);
        iFrame.setVisible(true);
        desktop.add(iFrame);
        frame.setContentPane(desktop);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class TransformingCanvas extends JComponent {
        private double translateX;
        private double translateY;
        private double scale;
        private final int PREF_W = 800; // Window width
        private final int PREF_H = 800; // Window height
        private static final Color INACTIVE_COLOR = Color.RED;
        private static final Color ACTIVE_COLOR = Color.green;
        private java.util.List<Point> points;
        private java.util.List<Ellipse2D> ellipses = new ArrayList<>();
        private Map<Ellipse2D, Color> ellipseColorMap = new HashMap<>();
        public static java.util.List<Point> POINT_LIST = new ArrayList<>();

        /*
         * This loop will initialize POINT_LIST with the set of points for
         * drawing the ellipses. The for each loop initializes points for the
         * top row and the second for loop draws the right triangle.
         */
        protected static void initializePointList() {

            int ellipsePointsYCoordinate[] = { 140, 200, 260, 320, 380, 440,
                    500, 560, 620 };
            int ellipsePointsXCoordinate[] = { 140, 200, 260, 320, 380, 440,
                    500, 560, 620, 680 };
            int xx = 80;

            for (int aXt : ellipsePointsXCoordinate) {
                POINT_LIST.add(new Point(aXt, xx));
            }

            for (int i = 0; i < ellipsePointsYCoordinate.length; i++) {
                for (int j = i; j < ellipsePointsYCoordinate.length; j++) {
                    POINT_LIST.add(new Point(ellipsePointsXCoordinate[i],
                            ellipsePointsYCoordinate[j]));
                }
            }
        }

        TransformingCanvas() {
            translateX = 0;
            translateY = 0;
            scale = 1;
            setOpaque(true);
            setDoubleBuffered(true);
        }

        public TransformingCanvas(java.util.List<Point> points) {
            this.points = points;
            int OVAL_WIDTH = 30;

            for (Point p : points) {

                int x = p.x - OVAL_WIDTH / 2;
                int y = p.y - OVAL_WIDTH / 2;
                int w = OVAL_WIDTH;
                int h = OVAL_WIDTH;
                Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
                ellipses.add(ellipse);
                ellipseColorMap.put(ellipse, INACTIVE_COLOR);
            }
        }

        @Override
        public void paint(Graphics g) {

            AffineTransform tx = new AffineTransform();
            tx.translate(translateX, translateY);
            tx.scale(scale, scale);
            Graphics2D g2 = (Graphics2D) g;
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setTransform(tx);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            for (Ellipse2D ellipse : ellipses) {
                g2.setColor(ellipseColorMap.get(ellipse));
                g2.fill(ellipse);
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(2));
                g2.draw(ellipse);
            }

            /*
             * Set the font characteristics, color, and draw the row labels.
             */
            g.setFont(new Font("TimesRoman", Font.BOLD, 18));
            g.setColor(Color.BLACK);

            // NOTE to self: add label DrawStrings back

            // Draws a 3DRect around the top row of ellipse2D objects
            g2.setColor(Color.lightGray);
            g2.draw3DRect(120, 60, 580, 40, true);
            g2.draw3DRect(121, 61, 578, 38, true);
            g2.draw3DRect(122, 62, 576, 36, true);
            // super.paint(g);
        }
    }

    private static class TranslateHandler implements MouseListener,
            MouseMotionListener {
        private int lastOffsetX;
        private int lastOffsetY;

        public void mousePressed(MouseEvent e) {
            // capture starting point
            lastOffsetX = e.getX();
            lastOffsetY = e.getY();
        }

        public void mouseDragged(MouseEvent e) {

            // new x and y are defined by current mouse location subtracted
            // by previously processed mouse location
            int newX = e.getX() - lastOffsetX;
            int newY = e.getY() - lastOffsetY;

            // increment last offset to last processed by drag event.
            lastOffsetX += newX;
            lastOffsetY += newY;

            // update the canvas locations
            canvas.translateX += newX;
            canvas.translateY += newY;

            // schedule a repaint.
            canvas.repaint();
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    private static class ScaleHandler implements MouseWheelListener {
        public void mouseWheelMoved(MouseWheelEvent e) {

        }
    }

    static class MyInternalFrame extends JInternalFrame implements
            InternalFrameListener {

        public MyInternalFrame() {
            super("iFrame", true, // resizable
                    true, // closable
                    true, // maximizable
                    true);// iconifiable
            setSize(300, 300);
            addInternalFrameListener(this);

        }

        @Override
        public void internalFrameActivated(InternalFrameEvent arg0) {

        }

        @Override
        public void internalFrameClosed(InternalFrameEvent arg0) {

        }

        @Override
        public void internalFrameClosing(InternalFrameEvent arg0) {

        }

        @Override
        public void internalFrameDeactivated(InternalFrameEvent arg0) {

        }

        @Override
        public void internalFrameDeiconified(InternalFrameEvent arg0) {

        }

        @Override
        public void internalFrameIconified(InternalFrameEvent arg0) {
            System.out.println("Minimized");


            //What you want to  do
        }

        @Override
        public void internalFrameOpened(InternalFrameEvent arg0) {

        }
    }
}