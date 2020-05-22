import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Canvas extends JComponent implements MouseListener, MouseMotionListener {

    private List<Point> points;

    public Canvas() {
        points = new ArrayList<>(25);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater((new Runnable() {
            @Override
            public void run() {
                JFrame window = new JFrame();
                window.add(new Canvas());
                window.pack();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
            }
        }));
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println(arg0);
        points.add(arg0.getPoint());
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        System.out.println(arg0);

    }

    public void paintComponent(Graphics g) {
        for (Point p : points) {
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        System.out.println(arg0);
        points.add(arg0.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        System.out.println(arg0);
    }

}