package javaapplication33;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.awt.EventQueue;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.table.AbstractTableModel;


public class JavaApplication33
{    

    public static void main(String[] args)
    {

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel p = new JPanel(new BorderLayout());                
                p.setPreferredSize(new Dimension(300,300));

                final Set<Point> erc = new HashSet<>(); //this set contains (row,cell) pairs of editable cells

                //put some data to the table
                final JTable table = new JTable(new String[][] 
                    {{"a", "aa"},
                    {"b", "bb"},
                    {"c", "cc"}},
                        new String[]{"col1", "col2"}) //name columns
                {                    
                    Collection<Point> editableRowsCells = erc;
                    Collection<Point> getEditableRowsCells()
                    {
                        return editableRowsCells;
                    }                    
                    public boolean isCellEditable(int row, int column)
                    {
                        return getEditableRowsCells()
                                .contains(new Point(row, column));
                    }
                };

                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                
                JScrollPane scrollpane = new JScrollPane(table); 

                p.add(scrollpane, BorderLayout.CENTER); 

                table.setRowHeight(28);
                table.setBackground(Color.DARK_GRAY);
                table.setForeground(Color.WHITE);

                final JTextField xf = new JTextField();
                final JTextField yf = new JTextField();
                Action enableAction = new AbstractAction("Enable")
                {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        int row = Integer.valueOf(xf.getText());
                        int col = Integer.valueOf(yf.getText());
                        erc.add(new Point(row,col));
                        ((AbstractTableModel) table.getModel())
                                .fireTableCellUpdated(row, col);
                    }
                };
                JButton enableButton = new JButton();
                enableButton.setAction(enableAction);
                Box b = new Box(BoxLayout.X_AXIS);
                b.add(new JLabel("Row"));
                b.add(xf);
                b.add(new JLabel("Col"));                
                b.add(yf);
                b.add(enableButton);

                p.add(b, BorderLayout.NORTH);

                f.add(p);
                f.pack();
                f.setVisible(true);
            }
        };
        EventQueue.invokeLater(r);
    }

}