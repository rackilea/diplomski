import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PleaseWait extends JPanel
{
    PleaseWait()
    {
        JTable table = new JTable(5, 5);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        add( new JScrollPane( table ) );

        JLabel label = new JLabel("Please Wait");
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBorder( new EmptyBorder(10, 10, 10, 10) );
        label.setSize( label.getPreferredSize() );
        label.setLocation(150, 20);
        table.add( label );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("PleaseWait");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PleaseWait());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}