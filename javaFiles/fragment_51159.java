import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class SSCCE extends JPanel
{
    private DefaultTableModel model;

    SSCCE()
    {
        setLayout( new BorderLayout() );

        model = new DefaultTableModel(0, 2);
        JTable table = new JTable( model );
        add(new JScrollPane( table ));

        JButton button = new JButton( "Add Row" );
        add(button, BorderLayout.PAGE_END);

        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Vector<Object> row = new Vector<Object>();
                row.add( "" + model.getRowCount() );
                row.add( new Date().toString() );
                model.addRow( row );
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}