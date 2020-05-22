import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class CheckBoxWrapperTableModel extends AbstractTableModel
{
    private ArrayList<Boolean> checkBoxes = new ArrayList<>();

    private DefaultTableModel model;
    private String columnName;

    public CheckBoxWrapperTableModel(DefaultTableModel model, String columnName)
    {
        this.model = model;
        this.columnName = columnName;

        for (int i = 0; i < model.getRowCount(); i++)
            checkBoxes.add( Boolean.FALSE );
    }

    @Override
    public String getColumnName(int column)
    {
        return (column > 0) ? model.getColumnName(column - 1) : columnName;
    }

    @Override
    public int getRowCount()
    {
        return model.getRowCount();
    }

    @Override
    public int getColumnCount()
    {
        return model.getColumnCount() + 1;
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        if (column > 0)
            return model.getValueAt(row, column - 1);
        else
        {
            Object value = checkBoxes.get(row);
            return (value == null) ? Boolean.FALSE : value;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        if (column > 0)
            return model.isCellEditable(row, column - 1);
        else
            return true;
    }

    @Override
    public void setValueAt(Object value, int row, int column)
    {
        if (column > 0)
            model.setValueAt(value, row, column - 1);
        else
        {
            checkBoxes.set(row, (Boolean)value);
        }

        fireTableCellUpdated(row, column);
    }

    @Override
    public Class getColumnClass(int column)
    {
        return (column > 0) ? model.getColumnClass(column - 1) : Boolean.class;
    }

    public void removeRow(int row)
    {
        checkBoxes.remove(row);
        fireTableRowsDeleted(row, row);
        model.removeRow(row);
    }

    private static void createAndShowGUI()
    {
        //  Create the table with check marks in the first column

        DefaultTableModel model = new DefaultTableModel(5, 1);

        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("" + i, i, 0);
        }

        CheckBoxWrapperTableModel wrapperModel = new CheckBoxWrapperTableModel(model, "Select");
        JTable table = new JTable(wrapperModel);

        //  Add button to delete selected rows

        JButton button = new JButton( "Delete Selected Rows" );
        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (int i = table.getRowCount() - 1; i >= 0; i--)
                {
                    Boolean selected = (Boolean)table.getValueAt(i, 0);
                    System.out.println(selected + " : " + i);

                    if (selected)
                    {
                        wrapperModel.removeRow(i);
                    }

                }
            }
        });

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane( table ) );
        frame.add( button, BorderLayout.PAGE_END );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
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