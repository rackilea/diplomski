import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class DataEntered implements DocumentListener
{
    private JButton button;
    private List<JTextField> textFields = new ArrayList<JTextField>();

    public DataEntered(JButton button)
    {
        this.button = button;
    }

    public void addTextField(JTextField textField)
    {
        textFields.add( textField );
        textField.getDocument().addDocumentListener( this );
    }

    public boolean isDataEntered()
    {
        for (JTextField textField : textFields)
        {
            if (textField.getText().trim().length() == 0)
                return false;
        }

        return true;
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        checkData();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        checkData();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {}

    private void checkData()
    {
        button.setEnabled( isDataEntered() );
    }

    private static void createAndShowUI()
    {
        JButton submit = new JButton( "Submit" );
        submit.setEnabled( false );

        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);

        DataEntered de = new DataEntered( submit );
        de.addTextField( textField1 );
        de.addTextField( textField2 );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField1, BorderLayout.WEST);
        frame.add(textField2, BorderLayout.EAST);
        frame.add(submit, BorderLayout.SOUTH);
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