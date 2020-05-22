import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;

public class ComboBoxColor extends JFrame
{
    public ComboBoxColor()
    {
        Object[] items = { Color.red, Color.green, Color.blue };
        JComboBox comboBox = new JComboBox( items );
        comboBox.setRenderer( new ColorRenderer( comboBox) );
        getContentPane().add( comboBox, BorderLayout.NORTH );
        add( new JTextField(), BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        ComboBoxColor frame = new ComboBoxColor();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    class ColorRenderer extends BasicComboBoxRenderer
    {
        JComboBox comboBox;
        Border border;


        public ColorRenderer(JComboBox comboBox)
        {
            this.comboBox = comboBox;
            border = new LineBorder( Color.WHITE );
        }

        public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            setText( value.toString() );

            if (!isSelected)
                setBackground( (Color)value );

            return this;
        }
    }
}