import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
class Person
{
    String name;
    String roll;
    String subject;
    public Person(String name,String roll,String subject)
    {
        this.name = name;
        this.roll = roll;
        this.subject = subject;
    }
    public String getName()
    {
        return name;
    }
    public String getRoll()
    {
        return roll;
    }
    public String getSubject()
    {
        return subject;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setRoll(String roll)
    {
        this.roll = roll;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
}
class TableRowAdd extends JFrame  
{
    private JTable table;
    private JScrollPane jsPane;
    private MyModel myModel;
    private JPanel dialogPanel;
    private JTextField tf[];
    private JLabel     lbl[];
    private JButton    button;
    JDialog dialog;
    public void prepareAndShowGUI()
    {
        myModel = new MyModel();
        table = new JTable(myModel);
        jsPane = new JScrollPane(table);
        button = new JButton("Add");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                dialog.setVisible(true);
            }
        });
        getContentPane().add(button,BorderLayout.SOUTH);
        getContentPane().add(jsPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareDialogPanel();
        pack();
        setVisible(true);

    }
    private void prepareDialogPanel()
    {
        dialogPanel = new JPanel();
        int col = table.getColumnCount();
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
        dialog = new JDialog(this,"Enter details",true);
        dialog.getContentPane().add(dialogPanel);
        JButton okButton = new JButton("OK");
        dialog.getContentPane().add(okButton,BorderLayout.SOUTH);
        okButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                dialog.dispose();
                myModel.addRow(new Person(tf[0].getText(),tf[1].getText(),tf[2].getText()));
            }
        });
        dialog.pack();
    }
    private class MyModel extends AbstractTableModel 
    {
        String[] columns = {
                            "Roll No.",
                            "Name",
                            "Subject"
                            };
        ArrayList<Person> inData = new ArrayList<Person>()
                            {
                                {
                                    add(new Person("1","Anthony Hopkins","CS01"));
                                    add(new Person("2","James William","CS02"));
                                    add(new Person("3","Mc. Donald","CS03"));
                                }
                            };
        @Override
        public void setValueAt(Object value, int row, int col)
        {
            Person person = inData.get(row);
            switch(col)
            {
                case 0: 
                    person.setRoll((String)value);
                    break;
                case 1:
                    person.setName((String)value);
                    break;
                case 2:
                    person.setSubject((String)value);
                    break;
                default:
                    System.out.println("Invalid col");

            }
            fireTableCellUpdated(row,col);
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            Person person = inData.get(row);
            switch(col)
            {
                case 0: 
                    return person.getRoll();
                case 1:
                    return person.getName();
                case 2:
                    return person.getSubject();
                default:
                    return null;
            }
        }
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override 
        public int getRowCount()
        {
            return inData.size();
        }
        @Override
        public String getColumnName(int col)
        {
            return columns[col];
        }
        @Override
        public boolean isCellEditable(int row ,int col)
        {
            return true;
        }
        //This method adds a row to the table
        public void addRow(Person person)
        {
            inData.add(person);
            fireTableRowsInserted(inData.size() - 1 ,inData.size() - 1);
        }
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                TableRowAdd td = new TableRowAdd();
                td.prepareAndShowGUI();
            }
        });
    }
}