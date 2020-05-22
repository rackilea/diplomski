import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Triangle extends JPanel {

    public void drawTriangle(Graphics2D g, 
            int x1, int y1, int x2, int y2, int x3, int y3, 
            int s, Color c, AffineTransform at) throws NoninvertibleTransformException{ 
        g.setStroke(new BasicStroke(3.0f));
        g.setPaint(c);
        int d = 10;
        g.drawLine(x1*s, y1*s, x2*s, y2*s);
        g.drawLine(x2*s, y2*s, x3*s, y3*s);
        g.drawLine(x3*s, y3*s, x1*s, y1*s);
        Ellipse2D center_of_triangle = new Ellipse2D.Double(.33*(x1+x2+x3)*s, .33*(y1+y2+y3)*s,4,4);
        g.draw(center_of_triangle);

        float dash1[] = {2.0f};
        BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        g.setStroke(dashed);

        g.drawLine(0,0,x1*s,y1*s);
        g.drawLine(0,0,x2*s,y2*s);
        g.drawLine(0,0,x3*s,y3*s);

        g.setColor(Color.black);
        Point2D point1origCoords = at.transform(new Point2D.Double(x1,y1),null);  
        Point2D point2origCoords = at.transform(new Point2D.Double(x2,y2),null);
        Point2D point3origCoords = at.transform(new Point2D.Double(x3,y3),null);
        g.drawString("("+String.format("%.2f",point1origCoords.getX())+", "
                +String.format("%.2f",point1origCoords.getY())+")",
                x1*s,y1*s+2*d);
        g.drawString("("+String.format("%.2f",point2origCoords.getX())+", "
                +String.format("%.2f",point2origCoords.getY())+")", x2*s-4*d,y2*s-d);
        g.drawString("("+String.format("%.2f",point3origCoords.getX())+", "
                +String.format("%.2f",point3origCoords.getY())+")", x3*s+d,y3*s);

        // center of the triangle
        Point2D.Double center = new Point2D.Double(.33*(x1+x2+x3), .33*(y1+y2+y3));
        Point2D centerorigCoords = at.transform(center,null);
        g.drawString("("+String.format("%.2f",centerorigCoords.getX())+", "
                +String.format("%.2f",centerorigCoords.getY())+")",
                (int)Math.round(center.x*s),(int)Math.round(center.y*s)-d);

    }

    public void drawGrid(Graphics2D g, int s) {  
        int w = getWidth();
        int h = getHeight();
        float dash1[] = {2.0f};
        BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        g.setStroke(dashed);
        g.setColor(Color.gray);

        int j = 0;
        while( j <= h ) {
            g.drawLine(0,h-j,w,h-j);
            j+=s;
        }
        j = 0;
        while( j <= w ) {
            g.drawLine(j,0,j,h);
            j+=s;
        }
    }

    public void paintComponent(Graphics g){
        final int s=20;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        Font big = new Font("Times New Roman", Font.BOLD,20);
        g2.setFont(big); 
        drawGrid(g2,s);  
        AffineTransform at = new AffineTransform();
        // no rotation
        at.rotate(Math.toRadians(0));
        g2.transform(at);
        // rotated triangle
        try {
            drawTriangle(g2,2,26,3,12,8,21,s,Color.blue,at);
        } catch (NoninvertibleTransformException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        at.rotate(Math.toRadians(-45));
        g2.transform(at);
        try {
            drawTriangle(g2,2,26,3,12,8,21,s,Color.magenta,at);
        } catch (NoninvertibleTransformException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Window"); //frame is the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Triangle panel = new Triangle(); //panel is the graphics area where we can draw

        frame.add(panel); //put the panel inside the window
        frame.setSize(600,600); //set the window size to 600x600 pixels
        frame.setVisible(true); 
    }
}