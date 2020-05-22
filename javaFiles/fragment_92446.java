import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class ShowBothInputs {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            public void run() {
                String[] items = {
                    "Apple",
                    "Banana",
                    "Grape",
                    "Cherry"
                };

                // what was requested
                EditableListPanel elp = new EditableListPanel(items);
                JOptionPane.showMessageDialog(null, elp);
                System.out.println( "EditableListPanel value: " + elp.getValue() );

                // probably what this UI actually needs
                JComboBox jcb = new JComboBox(items);
                jcb.setEditable(true);
                JOptionPane.showMessageDialog(null, jcb);
                System.out.println( "JComboBox value: " + jcb.getSelectedItem() );
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class EditableListPanel extends JPanel {

    private JTextField value;

    EditableListPanel(String[] items) {
        super( new BorderLayout(5,5) );

        final JList list = new JList( items );
        list.addListSelectionListener( new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent lse) {
                    value.setText( (String)list.getSelectedValue() );
                }
            } );
        add( list, BorderLayout.CENTER );

        value = new JTextField("", 20);
        add( value, BorderLayout.NORTH );
    }

    public String getValue() {
        return value.getText();
    }
}