import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TextAreaBottom extends JPanel implements DocumentListener
{
    private JTextArea textArea;

    public TextAreaBottom(JTextArea textArea)
    {
        this.textArea = textArea;

        setLayout( new BorderLayout() );
        setBackground( textArea.getBackground() );
        setBorder( textArea.getBorder() );
        textArea.getDocument().addDocumentListener(this);

        add(textArea, BorderLayout.SOUTH);
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        adjustHeight();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        adjustHeight();
    }

    @Override
    public void changedUpdate(DocumentEvent e)  {}

    private void adjustHeight()
    {
        int rows = textArea.getLineCount();
        textArea.setRows(rows);
    }

    private static void createAndShowUI()
    {
        final JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable( false );

        final JTextField textField = new JTextField(20);
        JButton send = new JButton( "Send" );
        send.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(textArea.getDocument().getLength() > 0)
                    textArea.append("\n");

                textArea.append( textField.getText() );

                textField.setText("");
                textField.requestFocusInWindow();
            }
        });

        JPanel panel = new JPanel( new BorderLayout() );
        panel.add(textField);
        panel.add(send, BorderLayout.EAST);

        JFrame frame = new JFrame("TextAreaBottom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane( new TextAreaBottom(textArea) ) );
        frame.add(panel, BorderLayout.SOUTH );
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