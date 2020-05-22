import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grids extends JPanel implements MouseMotionListener {

    public final static int WIDTH = 1200, HEIGHT = 800, POINT_SIZE = 10;
    private double mouseX, mouseY;
    private List<Point> points ; //stores all trail points
    private boolean drawTrail = true; //change to false to draw only one point at the mouse location

    public Grids() {
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        if(drawTrail) {
            points = new ArrayList<>(); //add mouse point to collection
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //set a min distance between points 
        if( Math.abs(mouseX - e.getX()) >= POINT_SIZE || Math.abs(mouseY - e.getY()) >= POINT_SIZE ) {
            if(drawTrail) {
                points.add(new Point(e.getX(),e.getY()));
            }
            mouseX = e.getX();
            mouseY = e.getY();
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();

        if(drawTrail){
            //draw all collected points
            for (Point p : points){
                Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                g.setColor(color);
                g.fillOval(p.x, p.y, POINT_SIZE, POINT_SIZE);
            }
        }else{
            //if you only want the point at the
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            g.setColor(color);
            g.fillOval((int)mouseX, (int)mouseY, POINT_SIZE, POINT_SIZE);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {/*todo*/}

    public static void main(String[] args0) {
        JFrame frame = new JFrame();
        frame.add(new Grids());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}