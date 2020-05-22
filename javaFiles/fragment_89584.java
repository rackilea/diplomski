import java.awt.*;
import javax.swing.*; 
import javax.swing.event.*;
import javax.swing.table.*;

public class TableFilterRow implements TableColumnModelListener
{

private JTable table;
private JPanel filterRow;

public TableFilterRow(JTable table,JPanel filterRow) 
{
    this.table = table;
    this.filterRow=filterRow;
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.getColumnModel().addColumnModelListener(this);
    table.columnMarginChanged(new ChangeEvent(table.getColumnModel()));
}

@Override
public void columnMarginChanged(ChangeEvent e) 
{
    TableColumnModel tcm = table.getColumnModel();

    int columns = tcm.getColumnCount();

    for (int i = 0; i < columns; i++)
    {
        JComboBox<?> comboBox = (JComboBox<?>) filterRow.getComponent(i);
        Dimension d = comboBox.getPreferredSize();
        d.width = tcm.getColumn(i).getWidth();
        comboBox.setPreferredSize(d);
    }

    SwingUtilities.invokeLater(new Runnable() 
    {
        @Override
        public void run() 
        {
        filterRow.revalidate();
        }
    });
}

@Override
public void columnMoved(TableColumnModelEvent e) 
{
     Component moved = filterRow.getComponent(e.getFromIndex());
     filterRow.remove(e.getFromIndex());
     filterRow.add(moved, e.getToIndex());
     filterRow.validate();
}

@Override
public void columnAdded(TableColumnModelEvent e) 
{

}

@Override
public void columnRemoved(TableColumnModelEvent e) 
{

}

@Override
public void columnSelectionChanged(ListSelectionEvent e) 
{

}

public static void main(String[] args) 
{
    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    JTable table = new JTable(3, 5);
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.columnMarginChanged(new ChangeEvent(table.getColumnModel()));

    ComboFields[] comboFields = ComboFields.values();

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);

    JPanel filterRow = new JPanel();
    filterRow.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

    for (int i = 0; i < table.getColumnCount(); i++) 
    {
        filterRow.add(new JComboBox<ComboFields>(comboFields));
    }
    new TableFilterRow(table, filterRow);

    frame.add(filterRow, BorderLayout.NORTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

private enum ComboFields{

    VALUE_0(0), 
    VALUE_1(1),
    VALUE_2(2),
    VALUE_3(3),
    VALUE_4(4),
    VALUE_5(5);
    // Internal state
    private int fieldNumber;

    private ComboFields(final int fieldNumber) 
    {
        this.setFieldNumber(fieldNumber);
    }

    @SuppressWarnings("unused")
    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) 
    {
        this.fieldNumber = fieldNumber;
    }
  }
}