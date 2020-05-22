import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.UIManager.*;


public class ToolTipPanel extends JPanel
{
    public ToolTipPanel()
    {
        setPreferredSize( new Dimension(200, 200) );
        setToolTipText("");
    }

    public void paintComponent(Graphics g)
    {
        g.setColor( Color.red );
        g.fillRect(0, 0, 100, 200);
        g.setColor( Color.blue );
        g.fillRect(100, 0, 100, 200);
    }

    public String getToolTipText(MouseEvent e)
    {
        if (e.getX() < 100)
            return "red";
        else
            return "blue";
    }

    public Point getToolTipLocation(MouseEvent e)
    {
        Point p = e.getPoint();
        p.y += 15;
        return p;

    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new ToolTipPanel() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}