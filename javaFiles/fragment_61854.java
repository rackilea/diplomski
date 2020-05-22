import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RectanglePanel extends JPanel{
    private Point anchorPoint = null;
    private Point intermediatePoint = null;
    private Point finalPoint = null;

    public RectanglePanel(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                if(anchorPoint == null){
                    // first click, set anchor point
                    anchorPoint = me.getPoint();
                }else if(finalPoint == null){
                    // second click, set final point
                    finalPoint = me.getPoint();
                }else{
                    // third click, reset clicks, anchor point, intermediate point and final point
                    anchorPoint = null;
                    finalPoint = null;
                    intermediatePoint = null;
                }
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me){
                if(anchorPoint != null && finalPoint == null){
                    // mouse moved
                    // set intermediate point if anchor point is set and final point is not set yet
                    intermediatePoint = me.getPoint();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(anchorPoint != null){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);

            Point p = finalPoint != null ? finalPoint : intermediatePoint;

            if(p != null && !p.equals(anchorPoint)){
                // final point or intermediate point is set, and is not same as anchor point
                // draw square

                // calculate angle to rotate canvas
                double angle = -Math.toRadians(45) + Math.atan2(p.y - anchorPoint.y, p.x - anchorPoint.x);
                // width of square, calculated using distance formaula and pythagorus theorem
                // distance formula: distance = sqrt((x1-x2)^2 + (y1-y2)^2)
                // pythagorus for right angled triangle: c^2 = a^2 + b^2
                double width = Math.sqrt(((p.x - anchorPoint.x) * (p.x - anchorPoint.x) + (p.y - anchorPoint.y) * (p.y - anchorPoint.y)) / 2.0);
                // set origin to anchorpoint
                g2d.translate(anchorPoint.x, anchorPoint.y);
                // rotate canvas
                g2d.rotate(angle);

                Rectangle2D rectangle2D = new Rectangle2D.Double(0, 0, width, width);
                // draw square
                g2d.draw(rectangle2D);

                // rotate back canvas
                g2d.rotate(-angle);

                // reset back origin
                g2d.translate(-anchorPoint.x, -anchorPoint.y);
            }else{
                g2d.drawRect(anchorPoint.x, anchorPoint.y, 1, 1);
            }
        }
    }

    public static void main(String [] args){
        final JFrame frame = new JFrame("Rectangle Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.getContentPane().add(new RectanglePanel());
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               frame.setVisible(true);
            }
        });
    }
}