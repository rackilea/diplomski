import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class TextPaneNoWrap
{
    private static void createAndShowGUI()
    {
        JTextPane textPane = new JTextPane()
        {
            @Override
            public boolean getScrollableTracksViewportWidth()
            {
                Dimension d = getParent().getSize();
                System.out.println(d);

                return false;
            }
        };
        textPane.setText("one two three four five six\nthis wraps at 39");
//      textPane.setText("import javax.swing.event.*;\nthis wraps at 111");

        JFrame frame = new JFrame("TextPaneNoWrap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("Some Component"), BorderLayout.LINE_START);
        frame.add(new JScrollPane( textPane ));
        frame.setSize(300, 100);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
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