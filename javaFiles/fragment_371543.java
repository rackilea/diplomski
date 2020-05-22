import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SSCCE extends JPanel
{
    SSCCE()
    {
        JPanel box = new JPanel();
        box.setLayout( new BoxLayout(box, BoxLayout.Y_AXIS) );
        box.setBorder( new LineBorder(Color.RED) );

        JTextField textField = new JTextField(10);
        //textField.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        System.out.println( textField.getAlignmentX() );
        box.add( textField );


        JLabel label = new JLabel("Some text");
        System.out.println( label.getAlignmentX() );
        box.add( label );

        add( box );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
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