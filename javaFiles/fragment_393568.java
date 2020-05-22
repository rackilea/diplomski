import java.awt.Color;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class ColoredTableCells2
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
        JTable table = new JTable()
        {
            @Override
            public Class<?> getColumnClass(int column) 
            {
                if (column == 0)
                {
                    return Object.class;
                }
                return Boolean.class;
            }
        };

        table.setDefaultEditor(Boolean.class, 
            new DelegatingTableCellEditor(table.getDefaultEditor(Boolean.class)));

        table.setDefaultRenderer(Boolean.class, 
            new DelegatingTableCellRenderer(table.getDefaultRenderer(Boolean.class)));

        table.setModel(new DefaultTableModel(new Object[][] {
            { "Row1", true,  false, true },
            { "Row2", true,  true,  false },
            { "Row3", false, false, true }, 
            { "Row3", false, true,  false } },
            new String[] { "Header1", "Header2", "Header3", "Header4" }));


        return table;
    }


    static class DelegatingTableCellEditor implements TableCellEditor
    {
        private final TableCellEditor delegate;

        DelegatingTableCellEditor(TableCellEditor delegate)
        {
            this.delegate = delegate;
        }

        @Override
        public Object getCellEditorValue()
        {
            return delegate.getCellEditorValue();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent)
        {
            return delegate.isCellEditable(anEvent); 
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent)
        {
            return delegate.shouldSelectCell(anEvent);
        }

        @Override
        public boolean stopCellEditing()
        {
            return delegate.stopCellEditing();
        }

        @Override
        public void cancelCellEditing()
        {
            delegate.cancelCellEditing();
        }

        @Override
        public void addCellEditorListener(CellEditorListener l)
        {
            delegate.addCellEditorListener(l);
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l)
        {
            delegate.removeCellEditorListener(l);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column)
        {

            Component component = 
                delegate.getTableCellEditorComponent(
                    table, value, isSelected, row, column);
            if (component instanceof JComponent)
            {
                JComponent c = (JComponent)component;
                c.setOpaque(true);
            }
            if (highlightCell(table, row, column))
            {
                component.setBackground(Color.CYAN);
            }
            else
            {
                component.setBackground(Color.WHITE);
            }
            return component;
        }

    }


    static class DelegatingTableCellRenderer extends DefaultTableCellRenderer          
    {
        private final TableCellRenderer delegate;

        DelegatingTableCellRenderer(TableCellRenderer delegate)
        {
            this.delegate = delegate;
        }

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
        {
            Component component = 
                delegate.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
            if (component instanceof JComponent)
            {
                JComponent c = (JComponent)component;
                c.setOpaque(true);
            }
            if (highlightCell(table, row, column))
            {
                component.setBackground(Color.CYAN);
            }
            else
            {
                component.setBackground(Color.WHITE);
            }
            return component;
        } 
    }

    private static boolean highlightCell(JTable table, int row, int column)
    {
        if (column == 1)
        {
            return false;
        }
        Object thisValue = table.getModel().getValueAt(row, column);
        Object referenceValue = table.getModel().getValueAt(row, 1);
        if (thisValue != null && referenceValue != null)
        {
            return thisValue.equals(referenceValue);
        }
        return false;
    }

}