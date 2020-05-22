package javaapplication33;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.table.AbstractTableModel;

public class JavaApplication33
{

    public static class Toggle
    {
        Boolean val;

        public Toggle(Boolean val)
        {
            this.val = val;
        }

        public void setVal(Boolean val)
        {
            this.val = val;
        }

        public Boolean getVal()
        {
            return val;
        }

        public void toggle()
        {
            setVal(!getVal());
        }
    }

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
                p.setPreferredSize(new Dimension(300, 300));

                final Toggle editable = new Toggle(false);

                final JTable table = new JTable(
                        new String[][]{
                            {"a", "aa"},
                            {"b", "bb"},
                            {"c", "cc"}},
                        new String[] {"col1", "col2"}) //name columns
                        {                           
                            public boolean isCellEditable(int row, int column)
                            {
                                return editable.getVal(); //request current value
                            }
                        };

                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane scrollpane = new JScrollPane(table);

                p.add(scrollpane, BorderLayout.CENTER);

                table.setRowHeight(28);
                table.setBackground(Color.DARK_GRAY);
                table.setForeground(Color.WHITE);

                Action enableAction = new AbstractAction("Toggle editable")
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        editable.toggle(); //toggle current value
                        ((AbstractTableModel) table.getModel()).fireTableStructureChanged();
                    }
                };
                JButton enableButton = new JButton();
                enableButton.setAction(enableAction);

                p.add(enableButton, BorderLayout.NORTH);

                f.add(p);
                f.pack();
                f.setVisible(true);
            }
        };
        EventQueue.invokeLater(r);
    }
}