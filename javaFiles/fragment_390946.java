import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class TextPaneNoWrap
{
    private static void createAndShowGUI()
    {
        JTextPane textPane = new JTextPane();

//      textPane.setText("one two three four five six\nthis wraps at 39");
        textPane.setText("import javax.swing.event.*;\nthis wraps at 111");

        JPanel wrapper = new NoWrapPanel(textPane);

        JFrame frame = new JFrame("TextPaneNoWrap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("Some Component"), BorderLayout.LINE_START);
        frame.add(new JScrollPane( wrapper ));
        frame.setSize(300, 100);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    static class NoWrapPanel extends JPanel implements Scrollable
    {
        public NoWrapPanel(JComponent component)
        {
            setLayout( new BorderLayout() );
            add( component );
        }

        @Override
        public Dimension getPreferredScrollableViewportSize()
        {
            return getPreferredSize();
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
        {
            return 20;
        }

        @Override
        public boolean getScrollableTracksViewportHeight()
        {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportWidth()
        {
//          return false;
            return getParent().getSize().width > 100;
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
        {
            return 10;
        }
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