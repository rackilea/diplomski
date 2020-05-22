import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.text.*;

public class TableBasic extends JPanel
{
    public TableBasic()
    {
        setLayout( new BorderLayout() );

        String[] columnNames = {"Date", "String", "Integer", "Boolean"};

        Object[][] data =
        {
            {new Date(), "A", new Integer(1), Boolean.TRUE },
            {new Date(), "B", new Integer(2), Boolean.FALSE},
            {new Date(), "C", new Integer(12), Boolean.TRUE },
            {new Date(), "D", new Integer(5124), Boolean.FALSE}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
            //  Returning the Class of each column will allow different
            //  renderers and editors to be used based on Class

            @Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
        };

        JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

        // Customize the icons of the renderer/editor used for Boolean data

        Icon selectedIcon = new ImageIcon( "copy16.gif" );
        Icon icon = new ImageIcon( "about16.gif" );

        DefaultCellEditor dce = (DefaultCellEditor)table.getDefaultEditor(Boolean.class);
        JCheckBox cbe = (JCheckBox)dce.getComponent();
        cbe.setSelectedIcon( selectedIcon );
        cbe.setIcon( icon );

        TableCellRenderer tcr = table.getDefaultRenderer(Boolean.class);
        JCheckBox cbr = (JCheckBox)tcr;
        cbr.setSelectedIcon( selectedIcon );
        cbr.setIcon( icon );
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("TableBasic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TableBasic() );
        frame.pack();
        frame.setLocationRelativeTo( null );
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