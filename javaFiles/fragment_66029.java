import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sample {

    public static void main(String[] args) {
        JFrame frame = new JFrame( "ComboBox Example" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JCheckBox checkBox = new JCheckBox( "Display Selecte Item" );
        final JTextField text = new JTextField( "" );
        text.setEditable( false );
        final JComboBox combo = new JComboBox( new String[] { "Item 1", "Item 2", "Item 3", "Item 4" } );
        checkBox.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox check = ( JCheckBox ) e.getSource();
                if( check.isSelected() ) {
                    Object obj = combo.getSelectedItem();
                    text.setEditable( true );
                    text.requestFocus();
                    text.setText(  obj == null ? "No Item Selected" : obj.toString() );
                }
            }
        } );

        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout( 3,2 ) );
        panel.add( new JLabel( " Select Item:" ) );
        panel.add( combo );
        panel.add( checkBox );
        panel.add( new JLabel( "" ) );
        panel.add( new JLabel( "Selected Item" ) );
        panel.add( text );

        frame.add( panel );
        frame.pack();;
        frame.setVisible( true);
    }

}