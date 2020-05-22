import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class TableComboBoxByRow extends JPanel
{
    List<TableCellEditor> editors = new ArrayList<TableCellEditor>(3);

    public TableComboBoxByRow()
    {
        setLayout( new BorderLayout() );

        // Create the editors to be used for each row

        String[] items1 = { "Red", "Blue", "Green" };
        JComboBox<String> comboBox1 = new JComboBox<String>( items1 );
        DefaultCellEditor dce1 = new DefaultCellEditor( comboBox1 );
        editors.add( dce1 );

        String[] items2 = { "Circle", "Square", "Triangle" };
        JComboBox<String> comboBox2 = new JComboBox<String>( items2 );
        DefaultCellEditor dce2 = new DefaultCellEditor( comboBox2 );
        editors.add( dce2 );

        String[] items3 = { "Apple", "Orange", "Banana" };
        JComboBox<String> comboBox3 = new JComboBox<String>( items3 );
        DefaultCellEditor dce3 = new DefaultCellEditor( comboBox3 );
        editors.add( dce3 );

        //  Create the table with default data

        Object[][] data =
        {
            {"Color", "Red"},
            {"Shape", "Square"},
            {"Fruit", "Banana"},
            {"Plain", "Text"}
        };
        String[] columnNames = {"Type","Value"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model)
        {
            //  Determine editor to be used by row
            public TableCellEditor getCellEditor(int row, int column)
            {
                int modelColumn = convertColumnIndexToModel( column );

                if (modelColumn == 1 && row < 3)
                    return editors.get(row);
                else
                    return super.getCellEditor(row, column);
            }
        };

        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

    }
    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Table Combo Box by Row");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TableComboBoxByRow() );
        frame.setSize(200, 200);
        frame.setLocationByPlatform( true );
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