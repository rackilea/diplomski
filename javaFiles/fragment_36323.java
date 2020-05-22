import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class CircleOrbit{

    private Circle center;
    private Circle orbiter;
    private int tick;

    //Amount in degrees * this const = amount in radians
    private static final double DEG_TO_RAD = Math.PI / 180;

    private static final int TIMER_DELAY = 25;

    /** Constructor for a CircleOrbit object.
     * Uses the given circle as the center circle, creates an
     * orbiter circle 1/10th the radius of the center and
     * on the x-axis of the center circle to start.
     * These constants should probably be pulled out to final ints
     * in a real implementation.
     */
    public CircleOrbit(Circle center){
        this.center = center;
        orbiter = new Circle(new Point2D.Double(), center.radius/10);
        tick = 0;
        updateOrbiterLoc();
    }

    /** Updates the location of the orbiter circle based on tick */
    private void updateOrbiterLoc(){
        Point2D.Double d = new Point2D.Double();
        final double xCenter = center.center.x;
        final double yCenter = center.center.y;
        final double rad = center.radius;
        d.setLocation(xCenter + rad * Math.cos(tick * DEG_TO_RAD),
                      yCenter + rad * Math.sin(tick * DEG_TO_RAD));
        orbiter.setCenter(d);
    }

    /** Increases tick and recalculates the position of the orbiter */
    public void tick(){
        tick += 1;
        updateOrbiterLoc();
    }

    /** Draws both of the circles in this CircleOrbit */
    public void draw(Graphics2D g){
        center.draw(g);
        orbiter.draw(g);
    }

    /** Creates a new panel to draw this orbit */
    public OrbitPanel getPanel(){
        return new OrbitPanel();
    }

    public static void main(String[] args){
        JFrame f = new JFrame();

        final CircleOrbit c = new CircleOrbit(new Circle(new Point2D.Double(250, 250), 200));

        final OrbitPanel o = c.getPanel();
        f.add(o, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Timer t = new Timer(TIMER_DELAY, null);
        t.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                c.tick();
                o.repaint();
                t.restart();
            }
        });
        t.start();
    }

    @SuppressWarnings("serial")
    class OrbitPanel extends JPanel{

        public OrbitPanel(){

            //Quick and dirty way of making sure the panel is big enough
            setPreferredSize(new Dimension(
                    (int)(center.center.x + center.radius * 1.1), 
                    (int)(center.center.y + center.radius * 1.1)
                ));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            CircleOrbit.this.draw((Graphics2D)g);
        }
    }

    static class Circle {

        private Point2D.Double center;
        private double radius;

        public Circle(Point2D.Double c, double r){
            center = c;
            radius = r;
        }

        public void setCenter(Point2D.Double c){
            center = c;
        }

        public void draw(Graphics2D g){
            int x = (int)(center.x - radius);
            int y = (int)(center.y - radius);
            int size = (int)(radius * 2);
            g.drawOval(x, y, size, size);
        }

        public String toString(){
            return center.toString() + " r=" + radius;
        }
    }
}