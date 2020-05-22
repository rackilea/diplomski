import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableCellListenerTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI()
    {
        String[] columnNames = {"Stock", "Shares", "Price", "Price Change", "Value"};
        Object[][] data =
        {
            {"IBM",    new Integer(100),  new Double(85),  new Double(0), new Double(8500)},
            {"Apple",  new Integer(300),  new Double(30),  new Double(0), new Double(9000)},
            {"Sun",    new Integer(1500), new Double(5),   new Double(0), new Double(7500)},
            {"Google", new Integer(100),  new Double(100), new Double(0), new Double(10000)}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }

            public boolean isCellEditable(int row, int column)
            {
                return column == 2;
            }
        };

        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);

        //  Add a sorter

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(sorter);

        //  Filter

        try
        {
            RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter("l", 0);
            sorter.setRowFilter(rf);
        }
        catch (java.util.regex.PatternSyntaxException e) {}

        Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                TableCellListener tcl = (TableCellListener)e.getSource();
                int column = tcl.getColumn();

                if (column == 2)
                {
                    int row = tcl.getRow();
                    double oldPrice = ((Double)tcl.getOldValue()).doubleValue();
                    double newPrice = ((Double)tcl.getNewValue()).doubleValue();
                    TableModel model = tcl.getTable().getModel();

                    double priceChange = new Double(newPrice - oldPrice);
                    model.setValueAt(priceChange, row, 3);

                    double shares = ((Integer)model.getValueAt(row, 1)).doubleValue();
                    Double value = new Double(shares * newPrice);
                    model.setValueAt(value, row, 4);
                }
            }
        };

      TableCellListener tcl = new TableCellListener(table, action);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Table Cell Listener");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( scrollPane );
        frame.setSize(400, 160);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}