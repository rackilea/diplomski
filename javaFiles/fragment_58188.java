import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TestTable {

    private JFrame f;
    private JTable table;

    private class MyCheckBoxRendererEditor extends JPanel implements TableCellRenderer, TableCellEditor, ActionListener {
        private JCheckBox checkbox;

        DefaultTableCellRenderer defaultRenderer;

        public MyCheckBoxRendererEditor() {
            defaultRenderer = new DefaultTableCellRenderer();
            checkbox = new JCheckBox();
            checkbox.setOpaque(false);
            checkbox.addActionListener(this);
            checkbox.setRequestFocusEnabled(false);
            setOpaque(true);
            add(checkbox);
            validate();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();
        }

        @Override
        public Object getCellEditorValue() {
            return checkbox.isSelected();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            for (CellEditorListener listener : getListeners(CellEditorListener.class)) {
                listener.editingStopped(new ChangeEvent(this));
            }
            return true;
        }

        @Override
        public void cancelCellEditing() {
            for (CellEditorListener listener : getListeners(CellEditorListener.class)) {
                listener.editingCanceled(new ChangeEvent(this));
            }
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            this.listenerList.add(CellEditorListener.class, l);
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            this.listenerList.remove(CellEditorListener.class, l);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            configure(table, value, true, true, row, column);
            return this;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            configure(table, value, isSelected, hasFocus, row, column);
            return this;
        }

        private void configure(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            defaultRenderer.setBackground(null);
            defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            MyObject myObject = ((MyTableModel) table.getModel()).getValueAt(row);
            checkbox.setVisible(myObject.getValue() != null);
            checkbox.setSelected((Boolean) value);
            setBackground(defaultRenderer.getBackground());
            setBorder(defaultRenderer.getBorder());
        }

    }

    private class MyObject {
        private final String value;
        private boolean checked;

        public MyObject(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
            System.err.println(value + " is " + checked);
        }
    }

    protected void initUI() {
        List<MyObject> data = new ArrayList<TestTable.MyObject>();
        for (int i = 0; i < 20; i++) {
            MyObject object = new MyObject(i % 3 == 1 ? null : "Row " + (i + 1));
            data.add(object);
        }
        table = new JTable(new MyTableModel(data));
        table.getColumnModel().getColumn(1).setCellEditor(new MyCheckBoxRendererEditor());
        table.getColumnModel().getColumn(1).setCellRenderer(new MyCheckBoxRendererEditor());
        table.setRowHeight(30);
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(table), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }

    public class MyTableModel extends AbstractTableModel {

        private List<MyObject> data;

        public MyTableModel(List<MyObject> data) {
            super();
            this.data = data;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        public MyObject getValueAt(int row) {
            return data.get(row);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return getValueAt(rowIndex).getValue();
            case 1:
                return getValueAt(rowIndex).isChecked();
            }
            return null;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 1) {
                getValueAt(rowIndex).setChecked((Boolean) aValue);
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1 && getValueAt(rowIndex).getValue() != null;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "Value";
            case 1:
                return "Checked";
            }
            return null;
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

}