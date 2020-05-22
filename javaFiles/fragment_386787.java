/*
    This is my understanding of how tabbing works. The focus manager
    recognizes the following default KeyStrokes for tabbing:

    forwards:  TAB or Ctrl-TAB
    backwards: Shift-TAB or Ctrl-Shift-TAB

    In the case of JTextArea, TAB and Shift-TAB have been removed from
    the defaults which means the KeyStroke is passed to the text area.
    The TAB KeyStroke inserts a tab into the Document. Shift-TAB seems
    to be ignored.

    This example shows different approaches for tabbing out of a JTextArea

    Also, a text area is typically added to a scroll pane. So when
    tabbing forward the vertical scroll bar would get focus by default.
    Each approach shows how to prevent the scrollbar from getting focus.
*/
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaTab extends JFrame
{
    public TextAreaTab()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add( nullTraversalKeys() );
        contentPane.add( writeYourOwnAction() );
        contentPane.add( useKeyListener() );
        contentPane.add( addTraversalKeys() );
    }

    //  Reset the text area to use the default tab keys.
    //  This is probably the best solution.

    private JComponent nullTraversalKeys()
    {
        JTextArea textArea = new JTextArea(3, 30);

        textArea.setText("Null Traversal Keys\n2\n3\n4\n5\n6\n7\n8\n9");
        JScrollPane scrollPane = new JScrollPane( textArea );
//        scrollPane.getVerticalScrollBar().setFocusable(false);

        textArea.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        textArea.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);

        return scrollPane;
    }

    //  Replace the Tab Actions. A little more complicated but this is the
    //  only solution that will place focus on the component, not the
    //  vertical scroll bar, when tabbing backwards (unless of course you
    //  have manually prevented the scroll bar from getting focus).

    private JComponent writeYourOwnAction()
    {
        JTextArea textArea = new JTextArea(3, 30);
        textArea.setText("Write Your Own Tab Actions\n2\n3\n4\n5\n6\n7\n8\n9");
        JScrollPane scrollPane = new JScrollPane( textArea );

        InputMap im = textArea.getInputMap();
        KeyStroke tab = KeyStroke.getKeyStroke("TAB");
        textArea.getActionMap().put(im.get(tab), new TabAction(true));
        KeyStroke shiftTab = KeyStroke.getKeyStroke("shift TAB");
        im.put(shiftTab, shiftTab);
        textArea.getActionMap().put(im.get(shiftTab), new TabAction(false));

        return scrollPane;
    }

    //  Use a KeyListener

    private JComponent useKeyListener()
    {
        JTextArea textArea = new JTextArea(3, 30);
        textArea.setText("Use Key Listener\n2\n3\n4\n5\n6\n7\n8\n9");
        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.getVerticalScrollBar().setFocusable(false);

        textArea.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_TAB)
                {
                    e.consume();
                    KeyboardFocusManager.
                        getCurrentKeyboardFocusManager().focusNextComponent();
                }

                if (e.getKeyCode() == KeyEvent.VK_TAB
                &&  e.isShiftDown())
                {
                    e.consume();
                    KeyboardFocusManager.
                        getCurrentKeyboardFocusManager().focusPreviousComponent();
                }
            }
        });

        return scrollPane;
    }

    //  Add Tab and Shift-Tab KeyStrokes back as focus traversal keys.
    //  Seems more complicated then just using null, but at least
    //  it shows how to add a KeyStroke as a focus traversal key.

    private JComponent addTraversalKeys()
    {
        JTextArea textArea = new JTextArea(3, 30);
        textArea.setText("Add Traversal Keys\n2\n3\n4\n5\n6\n7\n8\n9");
        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.getVerticalScrollBar().setFocusable(false);

        Set set = new HashSet( textArea.getFocusTraversalKeys(
            KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS ) );
        set.add( KeyStroke.getKeyStroke( "TAB" ) );
        textArea.setFocusTraversalKeys(
            KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set );

        set = new HashSet( textArea.getFocusTraversalKeys(
            KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS ) );
        set.add( KeyStroke.getKeyStroke( "shift TAB" ) );
        textArea.setFocusTraversalKeys(
            KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set );

        return scrollPane;
    }

    class TabAction extends AbstractAction
    {
        private boolean forward;

        public TabAction(boolean forward)
        {
            this.forward = forward;
        }

        public void actionPerformed(ActionEvent e)
        {
            if (forward)
                tabForward();
            else
                tabBackward();
        }

        private void tabForward()
        {
            final KeyboardFocusManager manager =
                KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    if (manager.getFocusOwner() instanceof JScrollBar)
                        manager.focusNextComponent();
                }
            });
        }

        private void tabBackward()
        {
            final KeyboardFocusManager manager =
                KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusPreviousComponent();

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    if (manager.getFocusOwner() instanceof JScrollBar)
                        manager.focusPreviousComponent();
                }
            });
        }
    }

    public static void main(String[] args)
    {
        TextAreaTab frame = new TextAreaTab();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}