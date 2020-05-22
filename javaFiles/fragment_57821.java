import java.awt.*;
import javax.swing.*;

public class ComboBoxIcon extends JFrame
{
    JComboBox comboBox;

    public ComboBoxIcon()
    {
        Object[] items =
        {
            new ImageIcon("about16.gif"),
            new ImageIcon("add16.gif"),
            new ImageIcon("copy16.gif")
        };
        comboBox = new JComboBox( items );
        getContentPane().add( comboBox, BorderLayout.NORTH );
    }

    public static void main(String[] args)
    {
        JFrame frame = new ComboBoxIcon();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}