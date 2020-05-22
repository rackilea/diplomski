import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Canvas extends JPanel {

    private static final long serialVersionUID = 1L;

    private boolean drawing;
    private List<Shape> myShapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Canvas());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public Canvas() {
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
        addSquare(100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void setList(ArrayList<Shape> shapes) {

    }

    public List<Shape> getList() {
        return null;
    }

    public void addSquare(int width, int height) {
        Path2D rect2 = new Path2D.Double();
        rect2.append(new Rectangle(getWidth() / 2 - width / 2, getHeight() / 2
                        - height / 2, width, height), true);

        myShapes.add(rect2);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        for (Shape shape : myShapes) {
            g2.draw(shape);
        }
    }

    class MyMouseAdapter extends MouseAdapter {

        private boolean pressed = false;
        private Point point;
        private Point offset;
        private Shape clickedShape;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            for (Shape shape : myShapes) {
                if (shape != null
                                && shape.contains(e.getPoint())) {
                    System.out.println("Clicked");
                    pressed = true;
                    clickedShape = shape;
                    this.point = e.getPoint();
                    int deltaX = point.x - shape.getBounds().x;
                    int deltaY = point.y - shape.getBounds().y;
                    offset = new Point(deltaX, deltaY);
                    System.out.println(point + "x" + offset);
                    repaint();
                    break;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (pressed) {
                int index = myShapes.indexOf(clickedShape);
                myShapes.remove(index);

                int deltaX = e.getPoint().x - offset.x;
                int deltaY = e.getPoint().y - offset.y;

                clickedShape = new Path2D.Double(clickedShape,
                                AffineTransform.getTranslateInstance(
                                                deltaX - clickedShape.getBounds().x,
                                                deltaY - clickedShape.getBounds().y));
                myShapes.add(index, clickedShape);
                point = e.getPoint();
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            offset = null;
            pressed = false;
        }
    }
}