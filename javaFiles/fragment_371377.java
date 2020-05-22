import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class OverlayPanel extends JPanel
{
    private static int ctr = 1;

    public OverlayPanel(String name)
    {
        setName( name );
        add( new JLabel("Label " + ctr++) );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        System.out.println("Painting: " + getName());
        super.paintComponent(g);
    }

    private static void createAndShowUI()
    {
        JPanel panel = new JPanel();
        panel.setLayout( new OverlayLayout(panel) );

        panel.add( new OverlayPanel("first") );
        panel.add( new OverlayPanel("second") );

        JPanel third = new OverlayPanel("third");
        third.setVisible(false);
        panel.add(third);

        JFrame frame = new JFrame("OverlayPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.pack();
        frame.setLocationByPlatform( true );
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