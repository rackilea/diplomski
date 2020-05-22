import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class ColoredTableCells
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.getContentPane().add(new JScrollPane(createTable()));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    static JTable createTable()
    {
        class ColoringTableCellRenderer extends DefaultTableCellRenderer
        {
            ColoringTableCellRenderer()
            {
                setOpaque(true);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column)
            {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                if (highlightCell(table, row, column))
                {
                    setBackground(Color.CYAN);
                }
                else
                {
                    setBackground(Color.WHITE);
                }
                return this;
            }

            private boolean highlightCell(JTable table, int row, int column)
            {
                Object thisValue = table.getValueAt(row, column);
                Object referenceValue = table.getValueAt(row, 1);
                if (thisValue != null && referenceValue != null)
                {
                    return thisValue.equals(referenceValue);
                }
                return false;
            }
        }

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {
            { "Row1", "1", "2", "3" },
            { "Row2", "2", "2", "3" },
            { "Row3", "2", "2", "2" }, 
            { "Row3", "2", "1", "2" } },
            new String[] { "Header1", "Header2", "Header3", "Header4" }));


        for (int i=2; i<table.getColumnCount(); i++)
        {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellRenderer(new ColoringTableCellRenderer());
        }
        return table;
    }
}