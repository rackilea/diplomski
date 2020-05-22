import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableBasic extends JFrame
{
    public TableBasic()
    {
        String[] columnNames = {"Date", "String", "Long", "Boolean"};
        Object[][] data =
        {
            {new Date(), "A", new Long(1), Boolean.TRUE },
            {new Date(), "B", new Long(2), Boolean.FALSE},
            {new Date(), "C", new Long(9), Boolean.TRUE },
            {new Date(), "D", new Long(4), Boolean.FALSE}
        };

        final JTable table = new JTable(data, columnNames)
        {
            //  Returning the Class of each column will allow different
            //  renderers and editors to be used based on Class

            public Class getColumnClass(int column)
            {
                // Lookup first non-null data on column
                for (int row = 0; row < getRowCount(); row++) 
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setAutoCreateRowSorter(true);
        // DefaultRowSorter has the sort() method
        DefaultRowSorter sorter = ((DefaultRowSorter)table.getRowSorter()); 
        ArrayList list = new ArrayList();
        list.add( new RowSorter.SortKey(2, SortOrder.ASCENDING) );
        sorter.setSortKeys(list);
        sorter.sort();

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    public static void main(String[] args)
    {
        TableBasic frame = new TableBasic();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}