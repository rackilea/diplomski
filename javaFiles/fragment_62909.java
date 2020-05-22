import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class TableFocus extends JFrame 
{
    MyTableModel model1;
    JTable table1;
    public void createAndShowGUI()
    {
        setTitle("JTables");
        Container c  = getContentPane();
        model1 = new MyTableModel();
        table1 = new JTable(model1);
        table1.setColumnSelectionAllowed(false);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsTable1 = new JScrollPane(table1);
        c.add(jsTable1);
        JButton button = new JButton("Delete");
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (model1.getRowCount() > 0 && table1.getSelectedRow() != -1 )
                {
                    model1.deleteRow(table1.getSelectedRow());
                }
            }
        });
        add(button,BorderLayout.SOUTH);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private class MyTableModel extends AbstractTableModel
    {
        String columns[] ;
        ArrayList<ArrayList<String>> data;
        public MyTableModel()
        {
            columns = new String[] {"Roll No.","Name"};
            prepareData();
        }
        private void prepareData()
        {
            data = new ArrayList<ArrayList<String>>();
            data.add(new ArrayList<String>(){{add("1");add("Michael");}});
            data.add(new ArrayList<String>(){{add("2");add("Derake");}});
            data.add(new ArrayList<String>(){{add("3");add("Archie");}});
        }
        @Override
        public String getColumnName(int columnIndex)
        {
            return columns[columnIndex];
        }
        @Override
        public int getRowCount()
        {
            return data.size();
        }
        @Override 
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return data.get(row).get(col);
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int colIndex)
        {
            data.get(rowIndex).set(colIndex,(String)aValue);
            fireTableCellUpdated(rowIndex,colIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
        public void deleteRow(int row)
        {
            ArrayList<String> temp = data.get(row);//backup of value in case of IOException while writing to file
            BufferedWriter bfr = null;
            try
            {
                data.remove(row);
                //Write here the logic for repopulating file with new records.
                bfr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("records.temp")));
                StringBuffer sBuffer = new StringBuffer();
                for (ArrayList<String> list : data)
                {
                    StringBuffer buf = new StringBuffer();
                    for (String val : list )
                    {
                        buf.append(val+"\t");
                    }
                    buf.replace(buf.length() - 1, buf.length(),"\n");
                    sBuffer.append(buf.toString());
                }
                bfr.write(sBuffer.toString());
                bfr.flush();
                bfr.close();
                fireTableRowsDeleted(row,row);
            }
            catch (Exception ex)
            {
                data.add(row,temp);//Rollback the delete from ArrayList
                ex.printStackTrace();
            }
            finally
            {
                if (bfr != null)
                {
                    try
                    {
                        bfr.close();
                    }
                    catch (Exception ex){}
                }
            }

        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                TableFocus ths = new TableFocus();
                ths.createAndShowGUI();
            }
        });
    }
}