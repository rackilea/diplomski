import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableProcessing extends JFrame implements TableModelListener
{
    JTable table;

    public TableProcessing()
    {
        super("Table");
        String[] columnNames = {"Item", "Quantity", "Price", "Cost"};
        Object[][] data =
        {
            {"Bread", new Integer(1), new Double(1.11), new Double(1.11)},
            {"Milk", new Integer(1), new Double(2.22), new Double(2.22)},
            {"Tea", new Integer(1), new Double(3.33), new Double(3.33)},
            {"Cofee", new Integer(1), new Double(4.44), new Double(4.44)}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        model.addTableModelListener( this );
//
        table = new JTable( model )
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }

            //  The Cost is not editable
            public boolean isCellEditable(int row, int column)
            {
                int modelColumn = convertColumnIndexToModel( column );
                return (modelColumn == 3) ? false : true;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
//
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );


        String[] items = { "Bread", "Milk", "Tea", "Coffee" };
        JComboBox editor = new JComboBox( items );

        DefaultCellEditor dce = new DefaultCellEditor( editor );
        table.getColumnModel().getColumn(0).setCellEditor(dce);
    }

    /*
     *  The cost is recalculated whenever the quantity or price is changed
     */
    public void tableChanged(TableModelEvent e)
    {
        if (e.getType() == TableModelEvent.UPDATE)
        {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == 1 || column == 2)
            {
                TableModel model = table.getModel();
                int quantity = ((Integer)model.getValueAt(row, 1)).intValue();
                double price = ((Double)model.getValueAt(row, 2)).doubleValue();
                Double value = new Double(quantity * price);
                model.setValueAt(value, row, 3);
            }
        }
    }

    public static void main(String[] args)
    {
        TableProcessing frame = new TableProcessing();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}