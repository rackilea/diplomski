import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class ShapeTransform extends JPanel
{
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private double scale = 1.0;

    public ShapeTransform()
    {
        shapes.add( new Ellipse2D.Double(10, 10, 20, 20) );
        shapes.add( new Ellipse2D.Double(30, 30, 20, 20) );
        shapes.add( new Ellipse2D.Double(50, 50, 20, 20) );
        shapes.add( new Ellipse2D.Double(70, 70, 20, 20) );

        addMouseListener( new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Point p = new Point((int)(e.getX() / scale), (int)(e.getY() / scale));

                for (Shape shape: shapes)
                {
                    if (shape.contains(p))
                    {
                        System.out.println("shape pressed");
                        return;
                    }
                }

                System.out.println("no shape pressed");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setColor( Color.BLUE );

        AffineTransform tx = new AffineTransform(); //
        tx.concatenate( g2d.getTransform() );
        tx.scale(scale, scale);
        g2d.setTransform(tx);

        for (Shape shape : shapes)
        {
            g2d.fill( shape );
        }

        g2d.dispose();
    }

    public void setScale(double scale)
    {
        this.scale = scale;
    }


    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("ShapeTransform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ShapeTransform());
        frame.setLocationByPlatform( true );
        frame.setSize(400, 400);
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}