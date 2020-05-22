import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ViewportBackground
{
    private static void createAndShowUI()
    {
        JViewport viewport = new JViewport()
        {
            @Override
            protected void paintChildren(Graphics g)
            {
                super.paintChildren(g);
                int w = this.getWidth();
                int h = this.getHeight();
                g.drawLine(0, 0, w, h);
            }
        };

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);
        scrollPane.setViewportView( new JLabel( new ImageIcon(...) ) );

        JFrame frame = new JFrame("Viewport Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( scrollPane );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}