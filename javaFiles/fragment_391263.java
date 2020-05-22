import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ComboBoxTwo extends JPanel implements ActionListener
{
    private JComboBox<String> mainComboBox;
    private JComboBox<String> subComboBox;
    private Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();

    public ComboBoxTwo()
    {
        String[] items = { "Select Item", "Color", "Shape", "Fruit" };
        mainComboBox = new JComboBox<String>( items );
        mainComboBox.addActionListener( this );

        //  prevent action events from being fired when the up/down arrow keys are used
        mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        add( mainComboBox );

        //  Create sub combo box with multiple models

        subComboBox = new JComboBox<String>();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        add( subComboBox );

        JButton arrow = SwingUtils.getDescendantOfType(JButton.class, subComboBox, "Text", "");
        Dimension d = arrow.getPreferredSize();
        System.out.println(arrow.getClass());
        System.out.println(d);
        d.width = 100;
        arrow.setPreferredSize(d);

        String[] subItems1 = { "Select Color", "Red", "Blue", "Green" };
        subItems.put(items[1], subItems1);

        String[] subItems2 = { "Select Shape", "Circle", "Square", "Triangle" };
        subItems.put(items[2], subItems2);

        String[] subItems3 = { "Select Fruit", "Apple", "Orange", "Banana" };
        subItems.put(items[3], subItems3);
    }

    public void actionPerformed(ActionEvent e)
    {
        String item = (String)mainComboBox.getSelectedItem();
        Object o = subItems.get( item );

        if (o == null)
        {
            subComboBox.setModel( new DefaultComboBoxModel() );
        }
        else
        {
            subComboBox.setModel( new DefaultComboBoxModel( (String[])o ) );
        }
    }

    private static void createAndShowUI()
    {
        try
        {
//          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) { }
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ComboBoxTwo() );
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