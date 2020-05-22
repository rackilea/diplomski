import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class NavigationFilterSuffix extends NavigationFilter
{
    private int suffixLength;
    private Document doc;

    public NavigationFilterSuffix(int suffixLength, Document doc)
    {
        this.suffixLength = suffixLength;
        System.out.println(suffixLength);
        this.doc = doc;
    }

    public void setDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        int endOfDocument = doc.getLength() - suffixLength + 1;
        fb.setDot(Math.min(dot, endOfDocument), bias);
    }

    public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        int endOfDocument = doc.getLength() - suffixLength + 1;
        fb.moveDot(Math.min(dot, endOfDocument), bias);
    }

    public static void main(String args[]) throws Exception
    {
        final JTextArea terminal = new JTextArea(15, 30);
        // add 14 new lines (one less than rows specified above
        terminal.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        terminal.setFont(new Font("Courier new", Font.PLAIN, 12));
        terminal.setBackground(Color.black);
        terminal.setForeground(Color.white);
        terminal.setCaretColor(Color.green);
        terminal.setDragEnabled(false);
        terminal.setCaretPosition(0);

        final JScrollPane scrollPane = new JScrollPane( terminal );

        Action enterAction = new EnterAction();
        terminal.getInputMap().put( KeyStroke.getKeyStroke("ENTER"), "enter");
        terminal.getActionMap().put("enter", enterAction);

        terminal.setNavigationFilter(new NavigationFilterSuffix(terminal.getRows(), terminal.getDocument()));

        JFrame frame = new JFrame("Navigation Filter Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        Dimension d = frame.getSize();
        d.width += 20;
        frame.setSize(d);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }


    static class EnterAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent ae )
        {
            try
            {
                final JTextArea terminal = (JTextArea)ae.getSource();
                Document doc = terminal.getDocument();
                int car = terminal.getCaretPosition();
                doc.insertString(car, "\n", null);

                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        JScrollPane scrollPane = (JScrollPane)SwingUtilities.getAncestorOfClass(JScrollPane.class, terminal);
                        JScrollBar sb = scrollPane.getVerticalScrollBar();
                        sb.setValue( sb.getMaximum());
                    }
                });

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}