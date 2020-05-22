import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
class TableRowEdit extends JFrame  
{
    private JTable table;
    private JScrollPane jsPane;
    private TableModel myModel;
    private JPanel dialogPanel;
    private JTextField tf[];
    private JLabel     lbl[];
    public void prepareAndShowGUI()
    {
        myModel = new MyModel();
        table = new JTable(myModel);
        jsPane = new JScrollPane(table);
        table.getColumnModel().getColumn(2).setCellRenderer(new LabelCellRenderer());
        table.addMouseListener(new MyMouseAdapter());
        getContentPane().add(jsPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareDialogPanel();
        pack();
        setVisible(true);

    }
    private void prepareDialogPanel()
    {
        dialogPanel = new JPanel();
        int col = table.getColumnCount() - 1;
        dialogPanel.setLayout(new GridLayout(col,2));
        tf = new JTextField[col];
        lbl = new JLabel[col];
        for (int i = 0; i < col; i++)
        {
            lbl[i] = new JLabel(table.getColumnName(i));
            tf[i] = new JTextField(10);
            dialogPanel.add(lbl[i]);
            dialogPanel.add(tf[i]);
        }
    }
    private void populateTextField(String[] s)
    {
        for (int i = 0 ; i < s.length ; i++ )
        {
            tf[i].setText(s[i]);
        }
    }
    public class LabelCellRenderer extends DefaultTableCellRenderer 
    {
        public Component getTableCellRendererComponent(JTable table,Object oValue, boolean isSelected, boolean hasFocus, int row, int column) 
        {
            Component c = super.getTableCellRendererComponent(table, oValue,isSelected, hasFocus,row, column);
            String value = (String)oValue;
            JLabel label =(JLabel)c;
            label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            label.setBackground(Color.lightGray);
            label.setHorizontalTextPosition(SwingUtilities.CENTER);
            label.setHorizontalAlignment(SwingUtilities.CENTER);
            label.setText(value);
            return label;
        }
    }

    private class MyMouseAdapter extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent evt)
        {
            int x = evt.getX();
            int y = evt.getY();
            int row = table.rowAtPoint(new Point(x,y));
            int col = table.columnAtPoint(new Point(x,y));
            if (col == 2)
            {
                String arr[] = new String[table.getColumnCount() - 1];
                for (int i = 0 ; i < arr.length ; i++)
                {
                    arr[i] = (String)table.getValueAt(row,i);
                }
                populateTextField(arr);
                JOptionPane.showMessageDialog(TableRowEdit.this,dialogPanel,"Information",JOptionPane.INFORMATION_MESSAGE);
                //Write here the code to save changed values to file and update to JTable also.
            }
        }
    }
    private class MyModel extends AbstractTableModel 
    {
        String[] columns = {
                            "Roll No.",
                            "Name",
                            "Action"
                            };
        String[][] inData = {
                                {"1","Huge Jackman","Edit"},
                                {"2","Thomas Andrews","Edit"},
                                {"3","Shiney","Edit"}
                            };
        @Override
        public void setValueAt(Object value, int row, int col)
        {
            inData[row][col] = (String)value;
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return inData[row][col];
        }
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override 
        public int getRowCount()
        {
            return inData.length;
        }
        @Override
        public String getColumnName(int col)
        {
            return columns[col];
        }
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                TableRowEdit td = new TableRowEdit();
                td.prepareAndShowGUI();
            }
        });
    }
}