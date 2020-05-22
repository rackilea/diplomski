import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class ListBottom2 extends JFrame
{
    JList list;
    JTextField textField;

    public ListBottom2()
    {
        DefaultListModel model = new DefaultListModel();
        model.add(0, "Adam");
        model.add(0, "Baker");
        model.add(0, "Charlie");
        list = new JList(model);
        list.setVisibleRowCount(5);

        JPanel box = new JPanel( new BorderLayout() );
        box.setBackground( list.getBackground() );
        box.add(list, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane( box );
        scrollPane.setPreferredSize(new Dimension(200, 95));
        add( scrollPane );

        textField = new JTextField("Use Enter to Add");
        getContentPane().add(textField, BorderLayout.NORTH );
        textField.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTextField textField = (JTextField)e.getSource();
                DefaultListModel model = (DefaultListModel)list.getModel();
//              model.addElement( textField.getText() );
                model.add(0, textField.getText());
                int size = model.getSize() - 1;
                list.scrollRectToVisible( list.getCellBounds(size, size) );
                textField.setText("");
            }
        });
    }

    public static void main(String[] args)
    {
        ListBottom2 frame = new ListBottom2();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}